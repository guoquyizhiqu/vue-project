/**
 * Created by liu on 12/7/2017.
 */




import Login from './views/core/Login.vue'
import Main from './views/core/Main.vue'
import Dashboard from './views/core/Dashboard.vue'

import BookInfoList from './views/book/bookInfo/List.vue'
import BookBorrowingList from './views/book/bookBorrowing/List.vue'
import BookReturnList from './views/book/bookReturn/List.vue'
import BookTypeList from './views/book/bookType/List.vue'
import BookUseRecordList from './views/book/bookUseRecord/List.vue'

import CommunityInfoList from './views/community/communityinfo/List.vue'
import NoticeList from './views/community/notice/List.vue'

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

            { path: '/book/book-info/list', component: BookInfoList, name: 'book-list' },
            { path: '/book/book-borrowing/list', component: BookBorrowingList, name: 'book-borrowing-list' },
            { path: '/book/book-return/list', component: BookReturnList, name: 'book-return-list' },
            { path: '/book/book-type/list', component: BookTypeList, name: 'book-type-list' },
            { path: '/book/book-use-record/list', component: BookUseRecordList, name: 'book-use-record-list' },


            { path: '/community/community-info/list', component: CommunityInfoList, name: 'community-info-list' },
            { path: '/community/notice/list', component: NoticeList, name: 'notice-list' },
        ]
    }
];

export default routes;