/**
 * Created by xingliu on 2018/1/3.
 */

import axios from '../api/api';

export const users = params => {
    return axios.post(`/api/user/list`, {page:"1",size: "5"}).then(user => {
        return user.data.data.list})
};
