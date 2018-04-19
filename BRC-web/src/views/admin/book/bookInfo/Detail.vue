<template>
    <div>
        <el-breadcrumb separator-class="el-icon-arrow-right" separator="/">
            <el-breadcrumb-item :to="{ path: 'list' }">图书管理</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: 'list' }">图书信息管理</el-breadcrumb-item>
            <el-breadcrumb-item>图书详情</el-breadcrumb-item>
        </el-breadcrumb>
        <el-col :span="6" :offset="9" style="padding-top: 80px">
            <el-form ref="form" :model="form" label-width="120px" class="detail"  v-loading="loading">
                <el-form-item label="图书名称:">
                    {{form.bookName}}
                </el-form-item>
                <el-form-item label="出版社:">
                    {{form.publisher}}
                </el-form-item>
                <el-form-item label="出版日期:">
                    {{form.publishTime}}
                </el-form-item>
                <el-form-item label="作者:">
                    {{form.author}}
                </el-form-item>
                <el-form-item label="价格:">
                    {{form.price}}
                </el-form-item>
                <el-form-item label="图书类型:">
                    {{form.bookType}}
                </el-form-item>
                <el-form-item>
                    <el-button @click="onCancel">返回</el-button>
                </el-form-item>
            </el-form>
        </el-col>
    </div>
</template>

<script>
    import {getBookInfo} from '../../../../module/admin/book/bookInfo';
    import {getBookType} from '../../../../module/admin/book/bookType';
    export default {
        data() {
            return{
                form: {
                    bookName: '',
                    publisher: '',
                    publishTime: '',
                    author: '',
                    price: '',
                    bookType: '',
                },
                loading: true
            }
        },
        mounted () {
            let _this = this;
            let bookInfoId = _this.$route.params.bookInfoId;
            this.$nextTick(function () {
                getBookInfo(bookInfoId).then(data => {
                    getBookType(data.bookType).then(bookType => {
                        _this.form.bookType = bookType.name;
                    });
                    _this.form.id = data.id;
                    _this.form.bookName = data.bookName;
                    _this.form.publisher = data.publisher;
                    _this.form.publishTime = data.publishTime;
                    _this.form.author = data.author;
                    _this.form.price = data.price;
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