<template>
    <div id="app">
        <el-breadcrumb separator-class="el-icon-arrow-right" separator="/">
            <el-breadcrumb-item :to="{ path: 'list' }">图书管理</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: 'list' }">图书借阅管理</el-breadcrumb-item>
            <el-breadcrumb-item>图书借阅</el-breadcrumb-item>
        </el-breadcrumb>
        <el-col :span="6" :offset="9" style="padding-top: 80px">
            <el-form ref="form" :model="form" label-width="120px" class="create">
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
                <el-form-item label="借阅人">
                    <template>
                       <!-- <el-select v-model="form.bookType" filterable placeholder="请选择">
                            <el-option
                                    v-for="item in form.bookTypeOptions"
                                    :key="item.id"
                                    :label="item.name"
                                    :value="item.id">
                            </el-option>
                        </el-select>-->
                    </template>
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
    import {getBookInfo} from '../../../../module/admin/book/bookInfo';
    import {getBookType} from '../../../../module/admin/book/bookType';
/*    import {borrowing} from '../../../../module/admin/book/bookBorrowing';*/
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
            console.log( _this.$route.params)
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
            onSubmit() {
                let _this = this;
                borrowing(this.form).then(function (data) {
                    _this.$message({
                        type: 'success',
                        center: true,
                        message: '借阅图书成功!'
                    });
                }).catch(function (error) {
                    _this.$message({
                        type: 'error',
                        center: true,
                        message: '借阅图书失败!'
                    });
                });
                this.$router.push({
                    name: "admin-book-borrowing-list"
                })
            },
            onCancel() {
                this.$router.push({
                    name: "admin-book-borrowing-list"
                })
            }
        }
    }
</script>