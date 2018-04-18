package com.liu.dao;

import com.liu.model.Reader;


import java.util.List;

public interface ReaderMapper {


    Boolean save(Reader reader);

    Boolean edit(Reader reader);

    List<Reader> selectAll();

    boolean deleteById(String id);

    Reader selectByPrimaryKey(String id);


    int deleteByPrimaryKey(String id);

    int insert(Reader record);

    int insertSelective(Reader record);


    int updateByPrimaryKeySelective(Reader record);

    int updateByPrimaryKey(Reader record);
}