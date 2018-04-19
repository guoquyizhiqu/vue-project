<template>
    <div>
        <el-breadcrumb separator-class="el-icon-arrow-right" separator="/">
            <el-breadcrumb-item>读者管理</el-breadcrumb-item>
            <el-breadcrumb-item>读者信息管理</el-breadcrumb-item>
        </el-breadcrumb>
        <el-row class="toolbar">
            <el-col :span="8">
                <el-input placeholder="请输入读者名称"  class="input-with-select">
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
                    <el-table-column prop="username" label="读者名称" width="180"></el-table-column>
                    <el-table-column prop="sex" label="性别" width="180"></el-table-column>
                    <el-table-column prop="age" label="年龄" sortable width="180"></el-table-column>
                    <el-table-column prop="number" label="学号" sortable width="180"></el-table-column>
                    <el-table-column prop="createTime" label="创建时间" sortable width="180"></el-table-column>
                    <el-table-column label="操作">
                        <template slot-scope="scope">
                            <div id="button">
                                <el-button
                                        size="small"
                                        @click="handleMethod(scope.row, 'user-edit')">编辑</el-button>
                                <el-button
                                        size="small"
                                        @click="handleMethod(scope.row, 'admin-reader-info-detail')">详情</el-button>
                                <el-button
                                        size="small"
                                        @click="deleteRow(scope.row, listUserData)">删除</el-button>
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

    import  { getReaderInfos } from '../../../../module/admin/reader/readerInfo';
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
            getReaderInfos(this);
        },
        methods: {
            handleSizeChange(val) {
                this.filter.pageSize = val;
                getReaderInfos(this);
            },
            handleCurrentChange(val) {
                this.filter.pageNum = val;
                getReaderInfos(this);
            },
            handleMethod(readerInfo, name) {
                this.$router.push({
                    name:name,
                    params: {
                        readerInfoId: readerInfo.id
                    }
                })
            },
            toCreate() {
                this.$router.push({
                    name: "admin-reader-info-create"
                })
            },
            deleteRow(index, rows) {
                this.$confirm('是否删除该图书?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.$message({
                        type: 'success',
                        center: true,
                        message: '删除成功!'
                    });
                    rows.splice(index, 1);
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        center: true,
                        message: '已取消删除'
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
