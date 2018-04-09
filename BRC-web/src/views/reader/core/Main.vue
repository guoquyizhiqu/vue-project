<template>
    <el-container>
        <el-header class="reader-header" style="height: 30px;">
            <v-header></v-header>
        </el-header>
        <el-main class="reader-main">
            <el-container>
                <el-header class="reader-main-header"><main-header></main-header></el-header>
                <el-container>
                    <el-aside class="reader-main-aside" width="200px"> <main-aside></main-aside></el-aside>
                    <el-main class="reader-main-content"> <main-content></main-content></el-main>
                </el-container>
            </el-container>
        </el-main>
    </el-container>
</template>

<script>
    import vHeader from '../../../components/reader/Header.vue'
    import mainHeader from '../../../components/reader/MainHeader.vue'
    import mainContent from '../../../components/reader/MainContent.vue'
    import mainAside from '../../../components/reader/MainAside.vue'
    export default {
        components: {
            vHeader, mainHeader,mainContent,mainAside
        }
    }
</script>
<style>
    .reader-header {
        background-color: #B3C0D1;
        color: #333;
        text-align: center;
    }
    .reader-main {
        background-color: #E9EEF3;
    }
    .reader-main-header {
    }
    .reader-main-aside {

    }
    .reader-main-content {

    }
</style>