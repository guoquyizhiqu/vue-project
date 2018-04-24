package com.liu.service;


import com.liu.model.BookComment;

import java.util.List;
import java.util.Map;

/**
 * Created by liu on 2018/3/26.
 */
public interface BookCommentService {
    Boolean add(BookComment bookComment);

    Boolean edit(BookComment bookComment);

    Boolean deleteById(String id);

    BookComment findById(String id);

    List<BookComment> findAll(int pageNum, int pageSize, Map<String, Object> queryMap);
}
