<template>
    <div id="app">
        <el-breadcrumb separator-class="el-icon-arrow-right" separator="/">
            <el-breadcrumb-item :to="{ path: 'list' }">图书管理</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: 'list' }">图书归还管理</el-breadcrumb-item>
            <el-breadcrumb-item>图书归还</el-breadcrumb-item>
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
                <el-form-item label="借阅人学号">
                    <template>
                        <el-select v-model="form.reader" @change="changeReader"  filterable placeholder="请输入学号">
                            <el-option
                                    v-for="item in form.readerOptions"
                                    :key="item.id"
                                    :label="item.number"
                                    :value="item">
                            </el-option>
                        </el-select>
                    </template>
                </el-form-item>
                <el-form-item label="借阅人:">
                    {{form.readerName}}
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
    import {borrowing} from '../../../../module/admin/book/bookBorrowing';
    import {getBookInfo} from '../../../../module/admin/book/bookInfo';
    import {getBookType} from '../../../../module/admin/book/bookType';
    import {readerInfo} from '../../../../module/admin/reader/readerInfo';

    import { setPage } from  '../../../../utils/page';

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
                    readerId: '',
                    readerOptions: [],
                    readerName:'',
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
                    _this.form.bookInfoId = data.id;
                    _this.form.bookName = data.bookName;
                    _this.form.publisher = data.publisher;
                    _this.form.publishTime = data.publishTime;
                    _this.form.author = data.author;
                    _this.form.price = data.price;
                    _this.loading = false;
                });
                let _this = this;
                let filter = {
                    pageNum: 1,
                    pageSize: 10000,
                };
                const params = setPage(filter);
                readerInfo(params).then(readerInfo => {
                    _this.form.readerOptions = readerInfo.list;
                })
            });
        },
        methods: {
            changeReader(val) {
                this.form.reader = val.number;
                this.form.readerName = val.username;
                this.form.readerId = val.id;
            },

            onSubmit() {
                let _this = this;
                let param = {
                    bookInfoId:_this.form.bookInfoId,
                    readerId: _this.form.readerId
                };
                borrowing(param).then(function (data) {
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