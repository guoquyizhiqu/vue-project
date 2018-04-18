package com.liu.service.impl;

import com.github.pagehelper.PageHelper;
import com.liu.dao.BookUseRecordMapper;
import com.liu.model.BookUseRecord;
import com.liu.service.BookUseRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liu on 2018/3/26.
 */
@Service(value = "bookUseRecordService")
public class BookUseRecordServiceImpl implements BookUseRecordService{

    @Resource
    BookUseRecordMapper bookUseRecordDao;

    @Override
    public Boolean add(BookUseRecord bookUseRecord) {
        Boolean flag = bookUseRecordDao.save(bookUseRecord);
        return flag;
    }

    @Override
    public Boolean edit(BookUseRecord bookUseRecord) {
        Boolean flag = bookUseRecordDao.edit(bookUseRecord);
        return flag;
    }

    @Override
    public Boolean deleteById(String id) {
        Boolean flag = bookUseRecordDao.deleteById(id);
        return flag;
    }

    @Override
    public BookUseRecord findById(String id) {
        return bookUseRecordDao.selectByPrimaryKey(id);
    }

    /*
   * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
   * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
   * pageNum 开始页数
   * pageSize 每页显示的数据条数
   * */
    @Override
    public List<BookUseRecord> findAll(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<BookUseRecord> list = bookUseRecordDao.selectAll();

        return list;
    }
}
