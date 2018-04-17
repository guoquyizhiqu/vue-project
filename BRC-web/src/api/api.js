/**
 * Created by xing on 12/10/2017.
 */

import axios from 'axios';
import qs from 'qs'

axios.defaults.headers.post["Content-Type"] = "application/json;charset=UTF-8";

axios.interceptors.request.use(function (config){
    // 处理请求之前的配置
    if(config.method === 'post') {
        config.data = qs.stringify(config.data);
        //post 提交时，将对象转换为string, 为处理Java后台解析问题
        /*  config.data = JSON.stringify(config.data)*/
    } else if(config.method === 'get') {
        // 给GET 请求后追加时间戳， 解决IE ajax 请求缓存问题
        /*        let symbol = config.url.indexOf("?") > 0 ? '&' : '?';
         config.url += symbol + Date.now();*/
    }
    return config;
}, function (error){
    // 请求失败的处理
    return Promise.reject(error);
});

const base = '/api';

export default axios;

export const test = params => {
    return axios.get(`${base}/getUser`, params).then(user => user.data)
};

export const login = params => {
    return axios.post(`${base}/login`, JSON.stringify(params)).then(user => user.data)
};


export const getKQs = params => {
    return axios.get(`${base}/kqs`).then(kqs => kqs.data)
};
export const getDKXs = params => {
    return axios.get(`${base}/dkxs`).then(dkxs => dkxs.data)
};

export const getTPs = params => {
    return axios.get(`${base}/tps`).then(tps => tps.data)
};

export const getEquipmentTypeDatas = params => {
    return axios.get(`${base}/equipment-type-datas`).then(equipmentTypeDatas => equipmentTypeDatas.data)
};

export const getEquipmentData = params => {
    return axios.get(`${base}/equipment-data`).then(equipmentData => equipmentData.data)
};

export const getModuleAgreements = params => {
    return axios.get(`${base}/module-agreements`).then(moduleAgreements => moduleAgreements.data)
};

export const getModuleModels = params => {
    return axios.get(`${base}/module-models`).then(moduleModels => moduleModels.data)
};

export const getModuleTypes = params => {
    return axios.get(`${base}/module-types`).then(getModuleTypes => getModuleTypes.data)
};

export const getModules = params => {
    return axios.get(`${base}/modules`).then(modules => modules.data)
};

export const getEquipmentModels = params => {
    return axios.get(`${base}/equipment-models`).then(equipmentModels => equipmentModels.data)
};

export const getEquipmentTypes = params => {
    return axios.get(`${base}/equipment-types`).then(equipmentTypes => equipmentTypes.data)
};


export const getEquipments = params => {
    return axios.get(`${base}/equipments`).then(equipments => equipments.data)
};

export const users = params => {
    return axios.get(`${base}/users`).then(user => user.data)
};

export const getUser = params => {
    return axios.get(`${base}/getUser`, params).then(user => {
        console.log(user.data)
        return user.data})
};

/*
 export const create = params => {
 return axios.post(`${base}/rfc/create`, JSON.stringify(params), {
 headers: {
 'Content-Type': 'application/json;charset=UTF-8'
 }
 }).then(res => res.data)
 };


 export const listRFC = params => {
 return axios.get(`${base}/rfc/list`, params).then(res => res.data)
 };

 export const getRFC = params => {
 return axios.get(`${base}/rfc/get`, params).then(res => res.data)
 };

 export const listGBM = () => {
 return axios.get(`${base}/rfc/gbm`).then(res => res.data)
 };

 export  const ListJobs = () => {
 return axios.get(`${base}/rfc/jobs`).then(res => res.data);
 };*/
