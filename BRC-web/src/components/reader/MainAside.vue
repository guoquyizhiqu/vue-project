<template>
    <div style="margin: 30px 0 0 0">
        <el-card class="box-card">
            <div slot="header">
                <span>新书推荐</span>
            </div>
            <div v-for="o in 10" :key="o" class="text item" style="padding: 5px 5px ">
                {{'图书 ' + o }}
            </div>
        </el-card>
        <!--<el-card class="box-card" style="margin: 30px 0 0 0" >
            <div slot="header">
                <span>新书推荐</span>
            </div>
            <div v-for="o in 10" :key="o" class="text item" style="padding: 5px 5px ">
                {{'图书 ' + o }}
            </div>
        </el-card>-->
    </div>
</template>
<script>
    export default {

    }
</script>