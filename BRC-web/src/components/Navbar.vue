<template>
    <el-col :span="24" class="header">
   <!--     <el-col :span="3" class="logo" :class="mainIsShow?'logo-collapse-width':'logo-width'">
           WX
        </el-col>-->
        <el-col :span="17">
     <!--       <span class="tools" @click.prevent="collapseHandler">
                <i class="el-icon-menu"></i>
            </span>-->
            <span style="font-size: 22px;padding-left: 60%">XXX管理系统</span>
        </el-col>
        <el-col :span="4" class="userinfo">
            <el-dropdown trigger="hover">
                <span class="el-dropdown-link userinfo-inner">张三

                    <i class="el-icon-caret-bottom"></i>
                </span>
                <el-dropdown-menu slot="dropdown">
                  <!--  <el-dropdown-item>我的消息</el-dropdown-item>-->
                    <el-dropdown-item>设置</el-dropdown-item>
                    <el-dropdown-item @click.native="logout">退出登录</el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
        </el-col>
    </el-col>

</template>

<script>

    export default {
        props: ['mainIsShow'],
        data() {
            return {

            };
        },
        methods: {
            collapseHandler() {
                this.$emit('listenChildEvent');
            },
            logout() {
                let _this = this;
                this.$confirm('确认退出吗?', '提示', {
                    //type: 'warning'
                }).then(() => {
                    sessionStorage.removeItem('user');
                    _this.$router.push('/login');
                }).catch(() => {

                });
            },
        },
    }
</script>

<style>
    .header {
        height: 60px;
        line-height: 60px;
        background: #20A0FF;
        color: #fff;
    }
    .logo {
        height:60px;
        font-size: 22px;
        padding-left:20px;
        padding-right:20px;
        border:0 solid hsla(62,77%,76%,.3);
        border-right-width: 1px;
    }
    .tools {
        padding: 0 23px;
        width:14px;
        height: 60px;
        line-height: 60px;
        cursor: pointer;
    }
    .logo-width {
        width: 230px;
    }
    .logo-collapse-width {
        width: 60px
    }
    .userinfo {
        text-align: right;
        padding-right: 35px;
        float: right;
    }
    .userinfo-inner {
        cursor: pointer;
        color: #fff;
    }
    img {
        width: 40px;
        height: 40px;
        border-radius: 20px;
        margin: 10px 0 10px 10px;
        float: right;
    }


</style>
