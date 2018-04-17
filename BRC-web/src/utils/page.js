/**
 * Created by liu on 2018/1/11.
 */


export const setPage = filter => {
    return {params:{'pageNum': filter.pageNum, 'pageSize': filter.pageSize}};
};