<template>
    <div>
        <el-breadcrumb separator-class="el-icon-arrow-right" separator="/">
            <el-breadcrumb-item :to="{ path: '/basic/user/list' }">基础信息管理</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/basic/user/list' }">用户管理</el-breadcrumb-item>
            <el-breadcrumb-item>修改用户</el-breadcrumb-item>
        </el-breadcrumb>
        <el-col :span="6" :offset="9" style="padding-top: 80px" >
            <el-form ref="user" :model="user" label-width="120px" class="edit" v-loading="loading">
                <el-form-item label="用户名">
                    <el-input v-model="user.name" placeholder="请输入用户名"></el-input>
                </el-form-item>
                <el-form-item label="地址">
                    <el-input v-model="user.address" placeholder="请输入地址"></el-input>
                </el-form-item>
                <el-form-item label="联系电话">
                    <el-input v-model="user.phone" placeholder="请输入联系电话"></el-input>
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
    import {getUser} from '../../../api/api';
    export default {
        data() {
            return{
                user: {
                    id: "",
                    name: "",
                    address: "",
                    phone: "",
                },
                loading: true
            }
        },
        mounted () {
            let _this = this;
            let userId = _this.$route.params.userId;
            if (userId === undefined || userId === null) {
                this.$router.push('/');
                return false;
            }
            this.$nextTick(function () {
                getUser(userId).then(data => {
                    _this.user = data.user;
                    _this.loading = false;
                })
            });
        },
        methods: {
            onSubmit() {
                this.$message({
                    type: 'success',
                    center: true,
                    message: '修改用户成功!'
                });
                this.$router.push({
                    name: "user-list"
                })
            },
            onCancel() {
                this.$router.push({
                    name: "user-list"
                })
            }
        }
    }


</script>