/**
 * Created by liu on 2018/3/20
 * */

import axios from '../../../api/api';

export const bookInfos = params => {
    return [{bookName:"aa"}]
    /*return axios.post(`/api/user/list`, {page:"1",size: "5"}).then(user => {
        return user.data.data.list})*/
};

export const create = params => {
    /*const bookInfo = {
        bookName: '',
        publisher: '',
        publishTime: new Date(),
        author: '',
        price: '',
        bookTypeName: '',
    };*/
    return axios({
        method: 'post',
        url: '/api/user/add',
        data: params,
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        }
    }).then(bookInfo => bookInfo)
        .then(function (response) {
            console.log(response);
        })
        .catch(function (error) {
            console.log(error);
        });
};
