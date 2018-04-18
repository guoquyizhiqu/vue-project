package com.liu.dao;

import com.liu.model.BookUseRecord;

import java.util.List;

public interface BookUseRecordMapper {

    Boolean save(BookUseRecord bookUseRecord);

    Boolean edit(BookUseRecord bookUseRecord);

    List<BookUseRecord> selectAll();

    boolean deleteById(String id);

    BookUseRecord selectByPrimaryKey(String id);


    int deleteByPrimaryKey(String id);

    int insert(BookUseRecord record);

    int insertSelective(BookUseRecord record);

    int updateByPrimaryKeySelective(BookUseRecord record);

    int updateByPrimaryKey(BookUseRecord record);
}