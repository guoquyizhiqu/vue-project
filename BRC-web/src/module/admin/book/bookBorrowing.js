/**
 * Created by liu on 2018/3/27.
 */
import axios from '../../../api/api';
import { post } from '../../../api/myAxios';
import { getListData } from  '../../../utils/page';

import { BOOKINFO_RETURN } from '../../../utils/myConstant';

export const getBookInfos = (_this) => {
    getListData(bookInfos, _this);
};

export const bookInfos = params => {
    params.params.borrowingStatus = BOOKINFO_RETURN; //已经借阅的图书状态
    return axios.get(`/api/book-info/list`, params)
        .then(bookInfo => {
            return bookInfo.data
        })
};

export const borrowing = params => {
    let param = {
        url:'/api/book-use-record/borrow',
        data: params
    };
    return post(param).then(data => data)
};

