<template>
    <el-col :span="3" class="aside-menu" :class="mainIsShow?'main-display-none':'main-display-block'" >
        <el-menu default-active="2" class="el-menu-vertical" @open="handleOpen" @close="handleClose" router>
            <el-submenu index="2">
                <template slot="title">图书管理</template>
                <el-menu-item index="/book/book-info/list">图书信息管理</el-menu-item>
                <el-menu-item index="/book/book-borrowing/list">图书借阅管理</el-menu-item>
                <el-menu-item index="/book/book-return/list">图书归还管理</el-menu-item>
                <el-menu-item index="/book/book-type/list">图书分类管理</el-menu-item>
                <el-menu-item index="/book/book-use-record/list">图书使用记录</el-menu-item>
            </el-submenu>
            <el-submenu index="3">
                <template slot="title">读者管理</template>
                <el-menu-item index="/equipment/equipment/list">读者信息管理</el-menu-item>
            </el-submenu>
            <el-submenu index="4">
                <template slot="title">社区管理</template>
                <el-menu-item index="/community/community-info/list">社区信息管理</el-menu-item>
                <el-menu-item index="/community/notice/list">公告管理</el-menu-item>

            </el-submenu>
            <el-submenu index="5">
                <template slot="title">预备模块</template>
                <el-menu-item index="5-1">选项4-1</el-menu-item>
            </el-submenu>
        </el-menu>
    </el-col>
</template>

<script>

    export default {
        props: ['mainIsShow'],
        data() {
            return {}
        },
        created:function(){
            this.$router.push('/core/dashboard'); // 页面加载时跳转
        },
        methods: {
            handleOpen(key, keyPath) {
                console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
                console.log(key, keyPath);
            },
        }
    }
</script>

<style>
    .main-display-block {
        display: block;
    }
    .main-display-none {
        display: none;
    }
    .el-menu-vertical {
        background-color: #eef1f6;
    }
   .aside-menu {
        flex: 0 0 230px;
        height: calc(100vh - 60px);
    }
    .el-menu-vertical{
        height: 100%;
    }
    .el-submenu .el-menu-item {
       /* background-color: #ecf5ff;*/
    }

</style>
