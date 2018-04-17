package com.liu.dao;

import com.liu.model.BookInfo;

import java.util.List;

public interface BookInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(BookInfo record);

    int insertSelective(BookInfo record);

    BookInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BookInfo record);

    int updateByPrimaryKey(BookInfo record);

    List<BookInfo> selectAllBookInfo();
}