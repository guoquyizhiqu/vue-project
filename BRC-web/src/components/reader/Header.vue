<template>
    <el-col :span="24">
        <el-col :span="2" :offset="16">
            <div class="welcome">
                    您好，<a href="login.html">请登录</a>&emsp;<a href="login.html">免费注册</a>
            </div>
        </el-col>
        <el-col :span="1">
            <div class="welcome">
                    <span class="el-dropdown-link">我的图书</span>
            </div>
        </el-col>
        <el-col :span="1">
            <div class="welcome">
                    <span class="el-dropdown-link">我的笔记</span>
            </div>
        </el-col>
        <el-col :span="1">
            <div class="welcome">
                    <span class="el-dropdown-link">我的评论&nbsp;</span>
            </div>
        </el-col>
    </el-col>
</template>
<style>
    .welcome {
        color: #777;
        font: normal 12px/36px Bitter, Myriad Pro, Verdana, serif;
    }
</style>
