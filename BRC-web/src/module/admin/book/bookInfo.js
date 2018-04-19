/**
 * Created by liu on 2018/3/20
 * */

import axios from '../../../api/api';
import { post } from '../../../api/myAxios';
import { getListData } from  '../../../utils/page';

export const getBookInfos = (_this) => {
    getListData(bookInfos, _this);
};

export const bookInfos = params => {
    return axios.get(`/api/book-info/list`, params)
        .then(bookInfo => {
            return bookInfo.data
        })
};

export const getBookInfo = params => {
    return axios.get(`/api/book-info/detail?id=`+params)
        .then(bookInfo => bookInfo.data)
};

export const create = params => {
    let param = {
        url:'/api/book-info/add',
        data: params
    };
    return post(param).then(data => data)
};

export const edit = params => {
    let param = {
        url:'/api/book-info/edit',
        data: params
    };
    return post(param).then(bookInfo => bookInfo)
};

export const remove = params => {
    let param = {
        url:'/api/book-info/delete',
        data: {id:params}
    };
    return post(param)
};