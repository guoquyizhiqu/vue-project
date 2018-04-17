<template>
    <div>
        <el-breadcrumb separator-class="el-icon-arrow-right" separator="/">
            <el-breadcrumb-item :to="{ path: 'list' }">图书管理</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: 'list' }">图书类型管理</el-breadcrumb-item>
            <el-breadcrumb-item>图书类型详情</el-breadcrumb-item>
        </el-breadcrumb>
        <el-col :span="6" :offset="9" style="padding-top: 80px">
            <el-form ref="user" :model="form" label-width="120px" class="detail"  v-loading="loading">
                <el-form-item label="用户名：">
                    {{form.name}}
                </el-form-item>
                <el-form-item label="地址：">
                    {{form.remark}}
                </el-form-item>

                <el-form-item>
                    <el-button @click="onCancel">返回</el-button>
                </el-form-item>
            </el-form>
        </el-col>
    </div>
</template>

<script>
    import {getBookType} from '../../../../module/admin/book/bookType';
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
            onCancel() {
                this.$router.push({
                    name: "admin-book-type-list"
                })
            }
        }
    }


</script>