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
    const bookInfo = {
        bookName: '张三',
        publisher: '2',
  /*      publishTime: new Date(),*/
        author: '43',
        price: '4',
        bookTypeName: '5',
    };
    return axios({
        method: 'post',
        url: '/api/book-info/add',
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
