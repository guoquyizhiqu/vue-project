package com.liu.service;


import com.liu.model.BookType;

import java.util.List;

/**
 * Created by liu on 2018/3/26.
 */
public interface BookTypeService {
    Boolean add(BookType bookType);

    Boolean edit(BookType bookType);

    Boolean deleteById(String id);

    BookType findById(String id);

    List<BookType> findAll(int pageNum, int pageSize);
}
