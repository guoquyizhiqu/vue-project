<template>
    <el-row>
        <el-col :span="3" v-for="(o, index) in 10" :key="o" style="margin: 7px 10px;">
            <el-card :body-style="{ margin: '0px' }">
                <img src="../../../resources/images/hamburger.png" class="image">
                <div style="padding: 14px;">
                    <span>好吃的汉堡</span>
                    <div class="bottom clear-fix">
                        <time class="time">{{ currentDate }}</time>
                        <el-button type="text" class="button">操作按钮</el-button>
                    </div>
                </div>
            </el-card>
        </el-col>
    </el-row>


</template>
<script>
    export default {
        data() {
            return {
                currentDate: new Date()
            };
        }
    }
</script>
<style>
    .time {
        font-size: 13px;
        color: #999;
    }

    .bottom {
        margin-top: 13px;
        line-height: 12px;
    }

    .button {
        padding: 0;
        float: right;
    }

    .image {
        width: 100%;
        height: 100%;
    }

    .clear-fix:before,
    .clear-fix:after {
        display: table;
        content: "";
    }

    .clear-fix:after {
        clear: both
    }
</style>