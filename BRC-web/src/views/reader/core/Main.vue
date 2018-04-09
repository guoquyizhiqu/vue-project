<template>
    <el-container>
        <el-header class="reader-header" style="height: 30px;">
            <v-header></v-header>
        </el-header>
        <el-main class="reader-main">
            <v-main></v-main>
        </el-main>
    </el-container>
</template>

<script>
    import vHeader from '../../../components/reader/Header.vue'
    import vMain from '../../../components/reader/Main.vue'
    export default {
        components: {
            vHeader, vMain
        }
    }
</script>
<style>
    .reader-header {
        background-color: #B3C0D1;
        color: #333;
        text-align: center;
        margin: 0 0;
    }
    .reader-main {
        background-color: #E9EEF3;
        margin: 0 0;
    }
</style>