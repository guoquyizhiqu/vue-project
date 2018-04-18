/**
 * Created by liu on 12/7/2017.
 */




import AdminLogin from './views/admin/core/Login.vue'
import AdminMain from './views/admin/core/Main.vue'
import AdminDashboard from './views/admin/core/Dashboard.vue'

import AdminBookInfoList from './views/admin/book/bookInfo/List.vue'
import AdminBookInfoCreate from './views/admin/book/bookInfo/Create.vue'
import AdminBookInfoEdit from './views/admin/book/bookInfo/Edit.vue'
import AdminBookInfoDetail from './views/admin/book/bookInfo/Detail.vue'

import AdminBookTypeList from './views/admin/book/bookType/List.vue'
import AdminBookTypeCreate from './views/admin/book/bookType/Create.vue'
import AdminBookTypeEdit from './views/admin/book/bookType/Edit.vue'
import AdminBookTypeDetail from './views/admin/book/bookType/Detail.vue'

import AdminBookBorrowingList from './views/admin/book/bookBorrowing/List.vue'
import AdminBookBorrowing from './views/admin/book/bookBorrowing/Borrowing.vue'
import AdminBookReturnList from './views/admin/book/bookReturn/List.vue'

import AdminBookUseRecordList from './views/admin/book/bookUseRecord/List.vue'

import AdminCommunityInfoList from './views/admin/community/communityinfo/List.vue'
import AdminNoticeList from './views/admin/community/notice/List.vue'
import AdminReaderInfoList from './views/admin/reader/readerInfo/List.vue'
import AdminReaderInfoCreate from './views/admin/reader/readerInfo/Create.vue'

import AdminUserList from './views/admin/basic/user/List.vue'
import AdminUserCreate from './views/admin/basic/user/Create.vue'
import AdminUserDetail from './views/admin/basic/user/Detail.vue'
import AdminUserEdit from './views/admin/basic/user/Edit.vue'



import ReaderMain from './views/reader/core/Main.vue'

let routes = [
    {
        path: '/admin/login',
        component: AdminLogin,
        name:'admin-login'
    },
    {
        path: '/',
        component: AdminMain,
        name:'admin-main',
        children: [
            { path: '/admin/core/dashboard', component: AdminDashboard, name: 'admin-dashboard' },

            { path: '/admin/basic/user/list', component: AdminUserList, name: 'admin-user-list' },
            { path: '/admin/basic/user/create', component: AdminUserCreate, name: 'admin-user-create' },
            { path: '/admin/basic/user/detail/:userId', component: AdminUserDetail, name: 'admin-user-detail' },
            { path: '/admin/basic/user/edit/:userId', component: AdminUserEdit, name: 'admin-user-edit' },

            { path: '/admin/book/book-info/list', component: AdminBookInfoList, name: 'admin-book-info-list' },
            { path: '/admin/book/book-info/create', component: AdminBookInfoCreate, name: 'admin-book-info-create' },
            { path: '/admin/book/book-info/edit', component: AdminBookInfoEdit, name: 'admin-book-info-edit' },
            { path: '/admin/book/book-info/detail', component: AdminBookInfoDetail, name: 'admin-book-info-detail' },

            { path: '/admin/book/book-type/list', component: AdminBookTypeList, name: 'admin-book-type-list' },
            { path: '/admin/book/book-type/create', component: AdminBookTypeCreate, name: 'admin-book-type-create' },
            { path: '/admin/book/book-type/edit', component: AdminBookTypeEdit, name: 'admin-book-type-edit' },
            { path: '/admin/book/book-type/detail', component: AdminBookTypeDetail, name: 'admin-book-type-detail' },

            { path: '/admin/book/book-borrowing/list', component: AdminBookBorrowingList, name: 'admin-book-borrowing-list' },
            { path: '/admin/book/book-borrowing', component: AdminBookBorrowing, name: 'admin-book-borrowing' },
            { path: '/admin/book/book-return/list', component: AdminBookReturnList, name: 'admin-book-return-list' },

            { path: '/admin/book/book-use-record/list', component: AdminBookUseRecordList, name: 'admin-book-use-record-list' },

            { path: '/admin/community/community-info/list', component: AdminCommunityInfoList, name: 'admin-community-info-list' },
            { path: '/admin/community/notice/list', component: AdminNoticeList, name: 'admin-notice-list' },

            { path: '/admin/reader/reader-info/list', component: AdminReaderInfoList, name: 'admin-reader-info-list' },
            { path: '/admin/reader/reader-info/create', component: AdminReaderInfoCreate, name: 'admin-reader-info-create' },
        ]
    },
    {
        path: '/reader',
        component: ReaderMain,
        name:'reader-main',
        children: [
            { path: '/reader/core', component: ReaderMain, name: 'reader-main' },
        ]
    },
];

export default routes;