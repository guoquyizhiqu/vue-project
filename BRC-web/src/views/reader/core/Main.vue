<template>
    <el-row>
        <v-header></v-header>
        <v-content></v-content>
    </el-row>
</template>

<script>
    import vHeader from '../../../components/reader/Header.vue'
    import vContent from '../../../components/reader/Content.vue'
    export default {
        components: {
            vHeader, vContent
        }
    }
</script>