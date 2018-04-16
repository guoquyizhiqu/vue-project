/**
 * Created by liu on 2018/1/3.
 */

import axios from '../api/api';

export const users = params => {
    return axios.post(`/api/user/list`, {page:"1",size: "5"}).then(user => {
        return user.data.data.list})
};


export const create = params => {
    alert(1);
    const user = {
        username:'n111',
        password:'131',
        phone:'112',
        address:'221',
        createDate:'2018/1/9'
    };
    return axios({
        method: 'post',
        url: '/api/user/add',
        data: user,
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        }
    }).then(user => user)
        .then(function (response) {
            console.log(response);
        })
        .catch(function (error) {
            console.log(error);
        });
};