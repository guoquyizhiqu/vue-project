<template>
    <div id="app">
        <el-breadcrumb separator-class="el-icon-arrow-right" separator="/">
            <el-breadcrumb-item :to="{ path: 'list' }">图书管理</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: 'list' }">图书信息管理</el-breadcrumb-item>
            <el-breadcrumb-item>新增图书</el-breadcrumb-item>
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
    import  { create } from '../../../../module/admin/book/bookInfo';
    import  { bookTypes} from '../../../../module/admin/book/bookType';
    import { setPage } from  '../../../../utils/page';
    import { Message } from 'element-ui';
    export default {
        data () {
            return {
                form: {
                    bookName: '',
                    publisher: '',
                    publishTime: '',
                    author: '',
                    price: '',
                    bookType: '',
                    bookTypeOptions: [],
                }
            }
        },
        mounted () {
            let _this = this;
            let filter = {
                pageNum: 1,
                pageSize: 10000,
            };
            const params = setPage(filter);
            bookTypes(params).then(bookType => {
                _this.form.bookTypeOptions = bookType.list;
            })
        },
        methods: {
            changeDate(val) {
                this.form.publishTime = val;
            },
            onSubmit() {
                let _this = this;
                create(this.form).then(function (data) {
                    _this.$message({
                        type: 'success',
                        center: true,
                        message: '添加图书成功!'
                    });
                }).catch(function (error) {
                    _this.$message({
                        type: 'error',
                        center: true,
                        message: '添加图书失败!'
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
            },
            setStep(step) {
                this.form.process = step;
            },
            checkDcode(val, oleVal) {
                if (oleVal !== undefined) {


                }
            }
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
