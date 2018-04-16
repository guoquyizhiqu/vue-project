<template>
    <div>
        <el-breadcrumb separator-class="el-icon-arrow-right" separator="/">
        <el-breadcrumb-item>基础信息管理</el-breadcrumb-item>
        <el-breadcrumb-item>用户管理</el-breadcrumb-item>
    </el-breadcrumb>
        <el-row class="toolbar">
            <el-col :span="8">
                <el-input placeholder="请输入用户名"  class="input-with-select">
                    <el-button slot="append" icon="el-icon-search"></el-button>
                </el-input>
            </el-col>
            <el-col :span="2" :offset="14">
                <el-button type="primary" @click="toCreate()"><span style="padding: 0 5px">新&nbsp;增</span></el-button>
            </el-col>
        </el-row>
        <el-row>
            <el-col :span="24">
                <el-table :data="listUserData" border style="width: 100%" v-loading="loading"
                          max-height="480"
                        :default-sort="{prop: 'date', order: 'descending'}"
                >
                    <el-table-column prop="username" label="用户姓名" sortable width="180"></el-table-column>
                    <el-table-column prop="registerDate" label="联系电话" sortable width="180"> </el-table-column>
                    <el-table-column label="操作">
                        <template slot-scope="scope">
                            <div id="button">
                                <el-button
                                        size="small"
                                        @click="handleMethod(scope.row, 'user-edit')">编辑</el-button>
                                <el-button
                                        size="small"
                                        @click="handleMethod(scope.row, 'user-detail')">详情</el-button>
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
                        :page-sizes="[100, 200, 300, 400]"
                        :page-size="100"
                        layout="total, sizes, prev, pager, next, jumper"
                        :total="400">
                </el-pagination>
            </el-col>
        </el-row>
    </div>
</template>

<script>
    /*import {users} from '../../../api/api';*/
   import  { users } from '../../../../module/user';
    import { Message } from 'element-ui';
    export default {
        data () {
            return {
                listUserData: [],
                search:'',
                loading: true,
                visible2: false,
                filter: {
                    page: '',
                    size: '',
                },
                currentPage4: 4
            }
        },
        mounted () {
            let _this = this;
            console.log(this)
            this.$nextTick(function () {
                users().then(users => {
                    console.log(users)
                    _this.listUserData = users;
                    _this.loading = false;
                })
            })
        },
        methods: {
            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
            },
            handleCurrentChange(val) {
                console.log(`当前页: ${val}`);
            },
            handleMethod(user, name) {
                let userId = user.id;
                this.$router.push({
                    name:name,
                    params: {
                        userId: userId
                    }
                })
            },
            toCreate() {
                this.$router.push({
                    name: "admin-user-create"
                })
            },
            deleteRow(index, rows) {
                this.$confirm('是否删除该用户?', '提示', {
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
