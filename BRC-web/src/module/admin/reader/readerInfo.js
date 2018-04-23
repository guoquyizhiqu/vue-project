/**
 * Created by liu on 2018/3/27.
 */
import axios from '../../../api/api';
import { post } from '../../../api/myAxios';
import { getListData } from  '../../../utils/page';

export const getReaderInfos = (_this) => {
    getListData(readerInfo, _this);
};

export const readerInfo = params => {
    return axios.get(`/api/reader/list`, params)
        .then(readerInfo => {
            return readerInfo.data
        })
};

export const getReaderInfo= params => {
    return axios.get(`/api/reader/detail?id=`+params)
        .then(bookInfo => bookInfo.data)
};

export const create = params => {
    let param = {
        url:'/api/reader/add',
        data: params
    };
    return post(param).then(data => data)
};

export const remove = params => {
    let param = {
        url:'/api/reader/delete',
        data: {id:params}
    };
    return post(param)
};