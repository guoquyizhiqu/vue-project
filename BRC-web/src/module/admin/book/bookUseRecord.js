/**
 * Created by liu on 2018/3/27.
 */

import axios from '../../../api/api';
import { getListData } from  '../../../utils/page';
import { BOOKINFO_RETURN } from '../../../utils/myConstant';
export const getBookUseRecords = (_this) => {
    getListData(bookUseRecords, _this);
};

export const bookUseRecords = params => {
    params.params.status = BOOKINFO_RETURN; //已经借阅的图书状态
    return axios.get(`/api/book-use-record/list`, params)
        .then(bookUseRecord => {
            return bookUseRecord.data
        })
};