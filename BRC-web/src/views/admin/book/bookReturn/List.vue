<template>
    <div>
        <el-breadcrumb separator-class="el-icon-arrow-right" separator="/">
            <el-breadcrumb-item>图书管理</el-breadcrumb-item>
            <el-breadcrumb-item>图书退还管理</el-breadcrumb-item>
        </el-breadcrumb>
        <el-row class="toolbar">
            <el-col :span="8">
                <el-input placeholder="请输入图书名称"  class="input-with-select">
                    <el-button slot="append" icon="el-icon-search"></el-button>
                </el-input>
            </el-col>
            <el-col :span="2" :offset="14">
                <el-button type="primary" @click="toCreate()"><span style="padding: 0 5px">新&nbsp;增</span></el-button>
            </el-col>
        </el-row>
        <el-row>
            <el-col :span="24">
                <el-table :data="listData" border style="width: 100%" v-loading="loading"
                          max-height="480"
                          :default-sort="{prop: 'date', order: 'descending'}"
                >
                    <el-table-column prop="bookName" label="图书名称" sortable width="180"></el-table-column>
                    <el-table-column prop="readerName" label="借阅人" sortable width="180"></el-table-column>
                    <el-table-column prop="borrowTime" label="借阅时间" sortable width="180"></el-table-column>
                    <el-table-column label="操作">
                        <template slot-scope="scope">
                            <div id="button">
                                <el-button
                                        size="small"
                                        @click="returnRow(scope.row)">归还</el-button>
                            </div>
                        </template>
                    </el-table-column>
                </el-table>
            </el-col>
        </el-row>
        <el-row  style="margin: 20px 0">
            <el-col :span="10" :offset="14">
                <el-pagination
                        @size-change="handleSizeChange"
                        @current-change="handleCurrentChange"
                        :current-page="currentPage4"
                        :page-sizes="[10, 20, 30, 40]"
                        :page-size="filter.pageSize"
                        layout="total, sizes, prev, pager, next, jumper"
                        :total="total">
                </el-pagination>
            </el-col>
        </el-row>
    </div>
</template>

<script>

    import  { getBookUseRecords, returnBook } from '../../../../module/admin/book/bookReturn';
    import { Message } from 'element-ui';
    export default {
        data () {
            return {
                listData: [],
                search:'',
                loading: true,
                visible2: false,
                filter: {
                    pageNum: 1,
                    pageSize: 10,
                },
                total: 0,
                currentPage4: 1,
            }
        },
        mounted () {
            let _this = this;
            getBookUseRecords(_this);
        },
        methods: {
            handleSizeChange(val) {
                this.filter.pageSize = val;
                getBookUseRecords(this);
            },
            handleCurrentChange(val) {
                this.filter.pageNum = val;
                getBookUseRecords(this);
            },
            handleMethod(bookUseRecord, name) {
                this.$router.push({
                    name:name,
                    params: {
                        bookUseRecordId: bookUseRecord.id
                    }
                })
            },
            returnRow(row) {
                let _this = this;
                _this.$confirm('是否归还该图书?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    returnBook(row.id).then(function (data) {
                        _this.$message({
                            type: 'success',
                            center: true,
                            message: '归还成功!'
                        });
                        getBookUseRecords(_this);
                    }).catch(function (error) {
                        _this.$message({
                            type: 'error',
                            center: true,
                            message: '归还失败'
                        });
                    });
                });
            }
        }
    }
</script>

<style>
    body {
        font-family: Helvetica, sans-serif;
    }
    .toolbar {
        margin: 20px 0;
    }
    .search {
        width: 300px;
    }
</style>
