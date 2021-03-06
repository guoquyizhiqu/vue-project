/**
 * Created by liu on 2018/1/11.
 */

export const setPage = filter => {
    return {params:{'pageNum': filter.pageNum, 'pageSize': filter.pageSize}};
};

export const getListData = (fun, _this) => {
    const params = setPage(_this.filter);
    fun(params).then(data => {
        _this.listData = data.list;
        _this.total = data.total;
        _this.loading = false;
    })
};