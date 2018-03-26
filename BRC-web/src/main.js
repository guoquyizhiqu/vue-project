import Vue from 'vue'
import ElementUI from 'element-ui'
//import 'element-ui/lib/theme-default/index.css'
import 'element-ui/lib/theme-chalk/index.css'
import App from './App.vue'
import VueRouter from 'vue-router'

Vue.use(ElementUI);
Vue.use(VueRouter);

import routes  from './routes'


const  router = new VueRouter({
    routes
});

/*
router.beforeEach((to, from, next) => {
    if (to.path === '/login') {
        sessionStorage.removeItem('sessionId');
    }
    let sessionId = JSON.parse(sessionStorage.getItem('sessionId'));
    if (!sessionId && to.path !== '/login') {
        next({ path: '/login' })
    } else {
        next()
    }
})
*/


new Vue({
    el: '#app',
    router,
    render: h => h(App)
}).$mount('#app');
