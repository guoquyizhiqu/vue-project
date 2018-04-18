<template>
    <div id="app">
        <el-breadcrumb separator-class="el-icon-arrow-right" separator="/">
            <el-breadcrumb-item :to="{ path: 'list' }">读者管理</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: 'list' }">读者信息管理</el-breadcrumb-item>
            <el-breadcrumb-item>新增读者</el-breadcrumb-item>
        </el-breadcrumb>
        <el-col :span="6" :offset="9" style="padding-top: 80px">
            <el-form ref="form" :model="form" label-width="120px" class="create">
                <el-form-item label="读者名称">
                    <el-input v-model="form.bookName" placeholder="请输入读者名称" ></el-input>
                </el-form-item>
                <el-form-item label="性别">
                    <el-input v-model="form.publisher" placeholder="请输入性别" ></el-input>
                </el-form-item>
                <el-form-item label="年龄">
                    <el-input v-model="form.publisher" placeholder="请输入年龄" ></el-input>
                </el-form-item>
                <el-form-item label="学号">
                    <el-input v-model="form.author" placeholder="请输入学号" ></el-input>
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
