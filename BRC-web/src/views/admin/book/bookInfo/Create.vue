<template>
    <div id="app">
        <el-breadcrumb separator-class="el-icon-arrow-right" separator="/">
            <el-breadcrumb-item>图书管理</el-breadcrumb-item>
            <el-breadcrumb-item>图书信息管理</el-breadcrumb-item>
            <el-breadcrumb-item>新增图书</el-breadcrumb-item>
        </el-breadcrumb>
        <el-col :span="6" :offset="9" style="padding-top: 80px">
            <el-form ref="form" :model="form" label-width="120px" class="create">
                <el-form-item label="用户名">
                    <el-input v-model="form.bookName" placeholder="请输入用户名" ></el-input>
                </el-form-item>
                <el-form-item label="出版社">
                    <el-input v-model="form.publisher" placeholder="请输入用户名" ></el-input>
                </el-form-item>
                <el-form-item label="出版日期">
                    <el-date-picker
                            v-model="form.publishTime"
                            type="date"
                            placeholder="选择日期">
                    </el-date-picker>
                </el-form-item>
                <el-form-item label="作者">
                    <el-input v-model="form.author" placeholder="请输入用户名" ></el-input>
                </el-form-item>
                <el-form-item label="价格">
                    <el-input v-model="form.price" placeholder="请输入用户名" ></el-input>
                </el-form-item>
                <el-form-item label="图书类型">
                    <el-input v-model="form.bookTypeName" placeholder="请输入用户名" ></el-input>
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
    import  { create } from '../../../../module/admin/book/bookInfo';
    import { Message } from 'element-ui';
    export default {
        data () {
            return {
                form: {
                    bookName: '',
                    publisher: '',
                    publishTime: new Date(),
                    author: '',
                    price: '',
                    bookTypeName: '',
                }
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
                console.log('submit!');
                console.log(JSON.stringify(this.form))
                create(this.form).then(data => {
                    console.log(data)
                })
                this.$router.push({
                    name: "admin-book-info-list"
                })
            },
            onCancel() {
                this.$router.push({
                    name: "admin-book-info-list"
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
