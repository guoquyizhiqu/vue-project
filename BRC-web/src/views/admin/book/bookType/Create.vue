<template>
    <div id="app">
        <el-breadcrumb separator-class="el-icon-arrow-right" separator="/">
            <el-breadcrumb-item :to="{ path: 'list' }">图书管理</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: 'list' }">图书类型管理</el-breadcrumb-item>
            <el-breadcrumb-item>新增图书类型</el-breadcrumb-item>
        </el-breadcrumb>
        <el-col :span="6" :offset="9" style="padding-top: 80px">
            <el-form ref="form" :model="form" label-width="120px" class="create">
                <el-form-item label="名称">
                    <el-input v-model="form.name" placeholder="请输入用户名" ></el-input>
                </el-form-item>
                <el-form-item label="描述">
                    <el-input v-model="form.remark" placeholder="请输入用户名" ></el-input>
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
    import  { create } from '../../../../module/admin/book/bookType';
    import { Message } from 'element-ui';
    export default {
        data () {
            return {
                form: {
                    name: '',
                    remark: '',
                }
            }
        },
        mounted () {
        },
        methods: {
            onSubmit() {
                create(this.form).then(data => {
                    this.$message({
                        type: 'success',
                        center: true,
                        message: '添加用户成功!'
                    });
                });
                this.$router.push({
                    name: "admin-book-type-list"
                })
            },
            onCancel() {
                this.$router.push({
                    name: "admin-book-type-list"
                })
            },
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
