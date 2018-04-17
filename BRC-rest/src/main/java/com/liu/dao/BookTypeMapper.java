package com.liu.dao;

import com.liu.model.BookInfo;
import com.liu.model.BookType;

import java.util.List;

public interface BookTypeMapper {

    Boolean save(BookType bookType);

    Boolean edit(BookType bookType);

    List<BookType> selectAll();

    boolean deleteById(String id);

    BookType selectByPrimaryKey(String id);


    int insertSelective(BookType record);



    int updateByPrimaryKeySelective(BookType record);

    int updateByPrimaryKeyWithBLOBs(BookType record);

    int updateByPrimaryKey(BookType record);


}