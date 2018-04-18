<template>
    <div>
        <el-breadcrumb separator-class="el-icon-arrow-right" separator="/">
            <el-breadcrumb-item :to="{ path: 'list' }">基础信息管理</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: 'list' }">用户管理</el-breadcrumb-item>
            <el-breadcrumb-item>修改用户</el-breadcrumb-item>
        </el-breadcrumb>
        <el-col :span="6" :offset="9" style="padding-top: 80px" >
            <el-form ref="user" :model="form" label-width="120px" class="edit" v-loading="loading">
                <el-form-item label="类型名称">
                    <el-input v-model="form.name" placeholder="请输入类型名称"></el-input>
                </el-form-item>
                <el-form-item label="描述">
                    <el-input v-model="form.remark" placeholder="请输入描述"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="onSubmit">更新</el-button>
                    <el-button @click="onCancel">取消</el-button>
                </el-form-item>
            </el-form>
        </el-col>
    </div>
</template>

<script>
    import {getBookType, edit} from '../../../../module/admin/book/bookType';
    export default {
        data() {
            return{
                form: {
                    id: '',
                    name: '',
                    remark: '',
                },
                loading: true
            }
        },
        mounted () {
            let _this = this;
            let bookTypeId = _this.$route.params.bookTypeId;
            if (bookTypeId === undefined || bookTypeId === null) {
                this.$router.push('/');
                return false;
            }
            this.$nextTick(function () {
                getBookType(bookTypeId).then(data => {
                    _this.form.id = data.id;
                    _this.form.name = data.name;
                    _this.form.remark = data.remark;
                    _this.loading = false;
                })
            });
        },
        methods: {
            onSubmit() {
                edit(this.form).then(data => {
                    this.$message({
                        type: 'success',
                        center: true,
                        message: '修改图书类型成功!'
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
            }
        }
    }


</script>