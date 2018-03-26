/**
 * Created by xing on 12/7/2017.
 */




import Login from './views/core/Login.vue'
import Main from './views/core/Main.vue'
import Dashboard from './views/core/Dashboard.vue'


import UserList from './views/basic/user/List.vue'
import UserCreate from './views/basic/user/Create.vue'
import UserDetail from './views/basic/user/Detail.vue'
import UserEdit from './views/basic/user/Edit.vue'

let routes = [
    {
        path: '/login',
        component: Login,
        name:'login'
    },
    {
        path: '/',
        component:Main,
        name:'Main',
        children: [
            { path: '/core/dashboard', component: Dashboard, name: 'dashboard' },

            { path: '/basic/user/list', component: UserList, name: 'user-list' },
            { path: '/basic/user/create', component: UserCreate, name: 'user-create' },
            { path: '/basic/user/detail/:userId', component: UserDetail, name: 'user-detail' },
            { path: '/basic/user/edit/:userId', component: UserEdit, name: 'user-edit' },

        ]
    }
];

export default routes;