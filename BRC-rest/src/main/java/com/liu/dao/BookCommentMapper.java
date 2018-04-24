package com.liu.dao;

import com.liu.model.BookComment;

import java.util.List;
import java.util.Map;

public interface BookCommentMapper {

    Boolean save(BookComment bookComment);

    Boolean edit(BookComment bookComment);

    List<BookComment> selectAll(Map<String, Object> queryMap);

    boolean deleteById(String id);

    BookComment selectByPrimaryKey(String id);

    int deleteByPrimaryKey(String id);

    int insert(BookComment record);

    int insertSelective(BookComment record);

    int updateByPrimaryKeySelective(BookComment record);

    int updateByPrimaryKey(BookComment record);
}