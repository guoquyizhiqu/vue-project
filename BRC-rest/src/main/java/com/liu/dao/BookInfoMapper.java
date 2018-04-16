package com.liu.dao;

import com.liu.model.BookInfo;

import java.util.List;

public interface BookInfoMapper {
    boolean insertSelective(BookInfo bookInfo);

    List<BookInfo> selectAllBookInfo();

    /*  @Select("SELECT * FROM user WHERE id = #{id}")*/
    BookInfo findById(String id);
}