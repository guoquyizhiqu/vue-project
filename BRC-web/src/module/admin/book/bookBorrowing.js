/**
 * Created by liu on 2018/3/27.
 */
import { post } from '../../../api/myAxios';

export const borrowing = params => {
    let param = {
        url:'/api/book-use-record/borrow',
        data: params
    };
    return post(param).then(data => data)
};

