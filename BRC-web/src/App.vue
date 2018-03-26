<template>
    <div id="app">
        <transition name="el-fade-in-linear" mode="out-in">
            <router-view></router-view>
        </transition>
    </div>
</template>

<script>
    export default {
        name: 'app',
        components: {}
    }
</script>

<style>
    body {
        font-family: Helvetica, sans-serif;
        padding: 0;
        margin: 0;
    }
</style>
