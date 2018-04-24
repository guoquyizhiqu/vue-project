package com.liu.service.impl;

import com.github.pagehelper.PageHelper;
import com.liu.dao.BookInfoMapper;
import com.liu.dao.BookCommentMapper;
import com.liu.model.BookInfo;
import com.liu.model.BookComment;
import com.liu.service.BookCommentService;
import com.liu.tools.MyConstant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by liu on 2018/3/26.
 */
@Service(value = "bookCommentService")
public class BookCommentServiceImpl implements BookCommentService{

    @Resource
    BookCommentMapper bookCommentDao;


    @Override
    public Boolean add(BookComment bookComment) {
        bookComment.setCreateTime(new Date());
        Boolean flag = bookCommentDao.save(bookComment);
        return flag;
    }

    @Override
    public Boolean edit(BookComment bookComment) {
        Boolean flag = bookCommentDao.edit(bookComment);
        return flag;
    }

    @Override
    public Boolean deleteById(String id) {
        Boolean flag = bookCommentDao.deleteById(id);
        return flag;
    }

    @Override
    public BookComment findById(String id) {
        return bookCommentDao.selectByPrimaryKey(id);
    }

    /*
   * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
   * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
   * pageNum 开始页数
   * pageSize 每页显示的数据条数
   * */
    @Override
    public List<BookComment> findAll(int pageNum, int pageSize, Map<String, Object> queryMap) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<BookComment> list = bookCommentDao.selectAll(queryMap);

        return list;
    }
}
