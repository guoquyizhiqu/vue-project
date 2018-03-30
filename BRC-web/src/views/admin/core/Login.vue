<template>
    <div class="login">
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" class="login-panel">
        <h3 class="title">xxx管理系统登录</h3>
        <el-form-item prop="account">
            <el-input type="text" v-model="ruleForm.account" placeholder="账号"></el-input>
        </el-form-item>
        <el-form-item prop="checkPass">
            <el-input type="password" v-model="ruleForm.checkPass" placeholder="密码"></el-input>
        </el-form-item>
        <el-checkbox v-model="checked" checked class="remember">记住密码</el-checkbox>
        <el-form-item>
            <el-button type="primary" class="btn-block" @click.native.prevent="submitForm('ruleForm')">登录
            </el-button>
        </el-form-item>
    </el-form>
    </div>
</template>

<script>

    import {login} from '../../../api/api'
    export default {
        data () {
            return {
                ruleForm: {
                    account: '',
                    checkPass: ''
                },
                rules: {
                    account: [
                        {required: true, message: '请输入账号', trigger: 'blur'},
                    ],
                    checkPass: [
                        {required: true, message: '请输入密码', trigger: 'blur'},
                    ]
                },
                checked: true
            }
        },
        methods: {
            submitForm(formName) {
                let _this = this;
                console.log(this.$refs[formName]);
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.$router.push({path: '/'});
                       /* login(_this.ruleForm).then(result => {
                            if (result.message === 'success') {
                                sessionStorage.setItem('sessionId', JSON.stringify(result.sessionId));
                                this.$router.push({path: '/'});
                            } else {
                                this.$message.error('登陆失败! 请联系管理员后重试');
                            }
                        })*/
                    } else {
                        return false;
                    }
                });
            }
        }
    }
</script>

<style>
    .login {
        padding-top: 25vh;
        text-align:center;
        background: black;
        height: 2000px;
    }
    .login-panel {
        background: white;
        margin: 0 auto;
        padding: 25px 40px;
        box-shadow: 0 0 25px #cac6c6;
        width: 300px;
    }
    .remember {
        margin-bottom: 10px;
    }
    .btn-block {
        width: 100%;
    }
</style>
