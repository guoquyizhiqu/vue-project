<template>
    <div id="app">
        <el-breadcrumb separator-class="el-icon-arrow-right" separator="/">
            <el-breadcrumb-item :to="{ path: 'list' }">图书管理</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: 'list' }">图书信息管理</el-breadcrumb-item>
            <el-breadcrumb-item>编辑图书</el-breadcrumb-item>
        </el-breadcrumb>
        <el-col :span="6" :offset="9" style="padding-top: 80px">
            <el-form ref="form" :model="form" label-width="120px" class="create">
                <el-form-item label="用户名">
                    <el-input v-model="form.bookName" placeholder="请输入用户名" ></el-input>
                </el-form-item>
                <el-form-item label="出版社">
                    <el-input v-model="form.publisher" placeholder="请输入出版社" ></el-input>
                </el-form-item>
                <el-form-item label="出版日期">
                    <el-date-picker
                            v-model="form.publishTime"
                            type="date"
                            @change="changeDate"
                            value-format="yyyy-MM-dd"
                            placeholder="选择出版日期">
                    </el-date-picker>
                </el-form-item>
                <el-form-item label="作者">
                    <el-input v-model="form.author" placeholder="请输入作者" ></el-input>
                </el-form-item>
                <el-form-item label="价格">
                    <el-input v-model="form.price" placeholder="请输入价格" ></el-input>
                </el-form-item>
               <el-form-item label="图书类型">
                    <template>
                        <el-select v-model="form.bookType" filterable placeholder="请选择">
                            <el-option
                                    v-for="item in form.bookTypeOptions"
                                    :key="item.id"
                                    :label="item.name"
                                    :value="item.id">
                            </el-option>
                        </el-select>
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
    import {getBookInfo, edit} from '../../../../module/admin/book/bookInfo';
    import {bookTypes} from '../../../../module/admin/book/bookType';
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
                    bookTypeOptions: [],
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
                    let filter = {
                        pageNum: 1,
                        pageSize: 10000,
                    };
                    const params = setPage(filter);
                    bookTypes(params).then(bookType => {
                        _this.form.bookTypeOptions = bookType.list;
                    });
                    _this.form.id = data.id;
                    _this.form.bookName = data.bookName;
                    _this.form.publisher = data.publisher;
                    _this.form.publishTime = data.publishTime;
                    _this.form.author = data.author;
                    _this.form.price = data.price;
                    _this.form.bookType = data.bookType;
                    _this.loading = false;
                })
            });
        },
        methods: {
            changeDate(val) {
                this.form.publishTime = val;
            },
            onSubmit() {
                edit(this.form).then(data => {
                    this.$message({
                        type: 'success',
                        center: true,
                        message: '修改图书成功!'
                    });
                });
                this.$router.push({
                    name: "admin-book-info-list"
                })
            },
            onCancel() {
                this.$router.push({
                    name: "admin-book-info-list"
                })
            }
        }
    }


</script>