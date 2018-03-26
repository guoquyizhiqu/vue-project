<template>
    <div id="app">
        <el-breadcrumb separator-class="el-icon-arrow-right" separator="/">
            <el-breadcrumb-item :to="{ path: '/basic/user/list' }">基础信息管理</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/basic/user/list' }">用户管理</el-breadcrumb-item>
            <el-breadcrumb-item>新增用户</el-breadcrumb-item>
        </el-breadcrumb>
        <el-col :span="6" :offset="9" style="padding-top: 80px">
            <el-form ref="form" :model="form" label-width="120px" class="create">
                <el-form-item label="用户名">
                    <el-input v-model="form.dcode" placeholder="请输入用户名" ></el-input>
                </el-form-item>
                <el-form-item label="密码">
                    <el-input v-model="form.password" placeholder="请输入密码"></el-input>
                </el-form-item>
                <el-form-item label="确认密码">
                    <el-input v-model="form.repassword" placeholder="请输入重复密码"></el-input>
                </el-form-item>

                <el-form-item>
                    <el-button type="primary" @click="onSubmit">保存</el-button>
                    <el-button @click="onCancel">取消</el-button>
                </el-form-item>
            </el-form>
        </el-col>
    </div>
</template>

<script>
    import {} from './../../../api/api'
    import { Message } from 'element-ui';
    export default {
        data () {
            return {
                form: {
                    dcode: '',
                    gbm: {
                        id: '1'
                    },
                    assignDate: new Date(),
                    date2: new Date(),
                    outPutDate: '',
                    expOutPutDate: '',
                    expDueDate: '',
                    delivery: false,
                    type: [],
                    level: 2,
                    desc: '',
                    process: 1
                },
                gbms: []
            }
        },
        mounted () {
            let _this = this;
          /*  this.$nextTick(function () {
                listGBM().then(data => {
                    _this.gbms = data;
                })
            })*/

        },
        methods: {
            onSubmit() {
                this.$message({
                    type: 'success',
                    center: true,
                    message: '添加用户成功!'
                });
                //console.log('submit!');
                /*console.log(JSON.stringify(this.form))
                create(this.form).then(data => {
                    console.log(data)
                })*/
                this.$router.push({
                    name: "user-list"
                })
            },
            onCancel() {
                this.$router.push({
                    name: "user-list"
                })
            },
            setStep(step) {
                this.form.process = step;
            },
            checkDcode(val, oleVal) {
                if (oleVal !== undefined) {


                }
            }
        },

    }
</script>

<style>
    .create .el-step {
        cursor: pointer;
    }

    .create .el-input, .create .el-date-editor.el-input {
        width: 200px;
    }

</style>
