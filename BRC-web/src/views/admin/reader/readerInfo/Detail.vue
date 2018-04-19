<template>
    <div>
        <el-breadcrumb separator-class="el-icon-arrow-right" separator="/">
            <el-breadcrumb-item :to="{ path: 'list' }">图书管理</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: 'list' }">图书信息管理</el-breadcrumb-item>
            <el-breadcrumb-item>图书详情</el-breadcrumb-item>
        </el-breadcrumb>
        <el-col :span="6" :offset="9" style="padding-top: 80px">
            <el-form ref="form" :model="form" label-width="120px" class="detail"  v-loading="loading">
                <el-form-item label="读者名称">
                    {{form.username}}
                </el-form-item>
                <el-form-item label="性别">
                    {{form.sex}}
                </el-form-item>
                <el-form-item label="年龄">
                    {{form.age}}
                </el-form-item>
                <el-form-item label="学号">
                    {{form.number}}
                </el-form-item>
                <el-form-item label="创建日期">
                    {{form.createTime}}
                </el-form-item>
                <el-form-item>
                    <el-button @click="onCancel">返回</el-button>
                </el-form-item>
            </el-form>
        </el-col>
    </div>
</template>

<script>
    import {getReaderInfo} from '../../../../module/admin/reader/readerInfo';
    export default {
        data() {
            return{
                form: {
                    username: '',
                    sex: '',
                    age: '',
                    number: '',
                    createTime: '',
                },
                loading: true
            }
        },
        mounted () {
            let _this = this;
            let readerInfoId = _this.$route.params.readerInfoId;
            this.$nextTick(function () {
                getReaderInfo(readerInfoId).then(data => {
                    _this.form = data;
                    _this.loading = false;
                })
            });
        },
        methods: {
            onCancel() {
                this.$router.push({
                    name: "admin-book-info-list"
                })
            }
        }
    }


</script>