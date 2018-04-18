package com.liu.service.impl;

import com.github.pagehelper.PageHelper;
import com.liu.dao.BookInfoMapper;
import com.liu.model.BookInfo;
import com.liu.service.BookInfoService;
import com.liu.tools.MyConstant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by liu on 2018/3/26.
 */
@Service(value = "bookInfoService")
public class BookInfoServiceImpl implements BookInfoService{

    @Resource
    BookInfoMapper bookInfoDao;

    @Override
    public Boolean addBookInfo(BookInfo bookInfo) {
        bookInfo.setCreateTime(new Date());
        bookInfo.setBorrowingStatus(MyConstant.BOOKINFO_RETURN);
        Boolean flag = bookInfoDao.insertSelective(bookInfo);
        return flag;
    }


    @Override
    public Boolean edit(BookInfo bookInfo) {
        Boolean flag = bookInfoDao.edit(bookInfo);
        return flag;
    }

    @Override
    public Boolean deleteById(String id) {
        Boolean flag = bookInfoDao.deleteById(id);
        return flag;
    }

    @Override
    public BookInfo findById(String id) {
        return bookInfoDao.selectByPrimaryKey(id);
    }

    /*
   * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
   * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
   * pageNum 开始页数
   * pageSize 每页显示的数据条数
   * */
    @Override
    public List<BookInfo> findAllBookInfo(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<BookInfo> list = bookInfoDao.selectAllBookInfo();

        return list;
    }
}
