/**
 * Created by liu on 12/7/2017.
 */




import Login from './views/admin/core/Login.vue'
import Main from './views/admin/core/Main.vue'
import Dashboard from './views/admin/core/Dashboard.vue'

import BookInfoList from './views/admin/book/bookInfo/List.vue'
import BookBorrowingList from './views/admin/book/bookBorrowing/List.vue'
import BookReturnList from './views/admin/book/bookReturn/List.vue'
import BookTypeList from './views/admin/book/bookType/List.vue'
import BookUseRecordList from './views/admin/book/bookUseRecord/List.vue'

import CommunityInfoList from './views/admin/community/communityinfo/List.vue'
import NoticeList from './views/admin/community/notice/List.vue'
import ReaderInfoList from './views/admin/reader/readerInfo/List.vue'

import UserList from './views/admin/basic/user/List.vue'
import UserCreate from './views/admin/basic/user/Create.vue'
import UserDetail from './views/admin/basic/user/Detail.vue'
import UserEdit from './views/admin/basic/user/Edit.vue'

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
            { path: '/admin/core/dashboard', component: Dashboard, name: 'admin-dashboard' },

            { path: '/admin/basic/user/list', component: UserList, name: 'admin-user-list' },
            { path: '/admin/basic/user/create', component: UserCreate, name: 'admin-user-create' },
            { path: '/admin/basic/user/detail/:userId', component: UserDetail, name: 'admin-user-detail' },
            { path: '/admin/basic/user/edit/:userId', component: UserEdit, name: 'admin-user-edit' },

            { path: '/admin/book/book-info/list', component: BookInfoList, name: 'admin-book-list' },
            { path: '/admin/book/book-borrowing/list', component: BookBorrowingList, name: 'admin-book-borrowing-list' },
            { path: '/admin/book/book-return/list', component: BookReturnList, name: 'admin-book-return-list' },
            { path: '/admin/book/book-type/list', component: BookTypeList, name: 'admin-book-type-list' },
            { path: '/admin/book/book-use-record/list', component: BookUseRecordList, name: 'admin-book-use-record-list' },

            { path: '/admin/community/community-info/list', component: CommunityInfoList, name: 'admin-community-info-list' },
            { path: '/admin/community/notice/list', component: NoticeList, name: 'admin-notice-list' },

            { path: '/admin/reader/reader-info/list', component: ReaderInfoList, name: 'admin-reader-info-list' },
        ]
    }
];

export default routes;