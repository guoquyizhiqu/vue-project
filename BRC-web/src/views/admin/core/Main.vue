<template>
    <el-row class="container">
        <v-navbar v-bind:mainIsShow="mainCollapsed" v-on:listenChildEvent="showChild"></v-navbar>
        <el-col :span="24" class="main">
            <v-sidebar v-bind:mainIsShow="mainCollapsed"></v-sidebar>
            <section class="content-container" style="width: 800px">
                <el-col :span="24" class="content-wrapper">
                    <transition name="fade" mode="out-in">
                        <router-view></router-view>
                    </transition>
                </el-col>
            </section>
        </el-col>
    </el-row>
</template>

<script>

    import vNavbar from '../../../components/admin/Navbar.vue'
    import vSidebar from '../../../components/admin/Sidebar.vue'
    export default {
        data () {
            return {
                mainCollapsed: false,
            }
        },

        components: {
            vNavbar, vSidebar
        },
        mounted () {

        },
        methods: {
            showChild () {
                this.mainCollapsed = !this.mainCollapsed;
            }
        }
    }
</script>

<style>
    html {
        overflow: hidden;
    }
    .main {
        display: flex;
    }

    .content-container {
        flex: 1;
        padding: 20px;
    }

    .content-wrapper {
        background-color: #fff;
        box-sizing: border-box;
    }
</style>
