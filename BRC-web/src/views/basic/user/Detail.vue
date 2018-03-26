<template>
    <div>
        <el-breadcrumb separator-class="el-icon-arrow-right" separator="/">
            <el-breadcrumb-item :to="{ path: '/basic/user/list' }">基础信息管理</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/basic/user/list' }">用户管理</el-breadcrumb-item>
            <el-breadcrumb-item>用户详情</el-breadcrumb-item>
        </el-breadcrumb>
        <el-col :span="6" :offset="9" style="padding-top: 80px">
            <el-form ref="user" :model="user" label-width="120px" class="detail"  v-loading="loading">
                <el-form-item label="用户名">
                    {{user.name}}
                </el-form-item>
                <el-form-item label="地址">
                    {{user.address}}
                </el-form-item>
                <el-form-item label="联系电话">
                    {{user.phone}}
                </el-form-item>
                <el-form-item>
                    <el-button @click="onCancel">返回</el-button>
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
            onCancel() {
                this.$router.push({
                    name: "user-list"
                })
            }
        }
    }


</script>