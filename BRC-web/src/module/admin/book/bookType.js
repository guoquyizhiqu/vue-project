/**
 * Created by liu on 2018/3/27.
 */
import axios from '../../../api/api';
import { post } from '../../../api/myAxios';

import { setPage } from  '../../../utils/page';

export const getBookTypes = (_this) => {
    const params = setPage(_this.filter);
    bookTypes(params).then(bookType => {
        _this.listData = bookType.list;
        _this.total = bookType.total;
        _this.loading = false;
    })
};

export const bookTypes = params => {
    return axios.get(`/api/book-type/list`, params)
        .then(bookType => {
            return bookType.data
        })
};

export const getBookType = params => {
    return axios.get(`/api/book-type/detail?id=`+params)
        .then(bookType => bookType.data)
};


export const create = params => {
    let param = {
        url:'/api/book-type/add',
        data: params
    };
    return post(param).then(bookInfo => bookInfo)
        .then(function (response) {
            console.log(response);
        })
        .catch(function (error) {
            console.log(error);
        });
};

export const edit = params => {
    let param = {
        url:'/api/book-type/edit',
        data: params
    };
    return post(param).then(bookType => bookType)
        .then(function (response) {
            console.log(response);
        })
        .catch(function (error) {
            console.log(error);
        });
};

export const remove = params => {
    let param = {
        url:'/api/book-type/delete',
        data: {id:params}
    };
    return post(param)
};