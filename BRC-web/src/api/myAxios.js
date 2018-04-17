/**
 * Created by liu on 2018/4/17.
 */
import axios from './api';

export const post = params => {
    return axios({
        method: 'post',
        url: params.url,
        data: params.data,
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        }
    }).then(data => data)
};