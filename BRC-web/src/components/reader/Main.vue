<template>
    <el-container style="margin: 0 0; padding: 0 0;">
        <el-header class="reader-main-header"><main-header></main-header></el-header>
        <el-container>
            <el-aside class="reader-main-aside" width="200px"> <main-aside></main-aside></el-aside>
            <el-main class="reader-main-content"> <main-content></main-content></el-main>
        </el-container>
    </el-container>
</template>

<script>
    import mainHeader from './MainHeader.vue'
    import mainContent from './MainContent.vue'
    import mainAside from './MainAside.vue'
    export default {
        components: {
            mainHeader,mainContent,mainAside
        }
    }
</script>
<style>
    .reader-main-header {
    }
    .reader-main-aside {

    }
    .reader-main-content {

    }
</style>