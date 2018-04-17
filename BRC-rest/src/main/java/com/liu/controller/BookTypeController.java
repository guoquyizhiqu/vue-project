package com.liu.controller;


import com.github.pagehelper.PageInfo;
import com.liu.model.BookType;
import com.liu.service.BookTypeService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


/**
 * Created by liu on 2018/3/26.
 */
@RestController
@RequestMapping(value = "/book-type")
public class BookTypeController {

    @Autowired
    private BookTypeService bookTypeService;

    @ResponseBody
    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public String add(HttpServletRequest req, BookType bookType) {
        bookType.setCreateDate(new Date());
        bookTypeService.add(bookType);
        return "success";
    }

    @ResponseBody
    @PostMapping(value = "/edit", produces = {"application/json;charset=UTF-8"})
    public String edit(HttpServletRequest req, BookType bookType) {
        bookType.setUpdateDate(new Date());
        bookTypeService.edit(bookType);
        return "success";
    }


    @RequestMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public PageInfo findAllBookType(int pageNum, int pageSize) {
        List<BookType> list = bookTypeService.findAll(pageNum, pageSize);
        return new PageInfo(list);
    }

    @RequestMapping(value = "/detail", produces = {"application/json;charset=UTF-8"})
    public BookType findBookType(String id) {
        BookType bookType = bookTypeService.findById(id);
        return bookType;
    }

    @ResponseBody
    @PostMapping(value = "/delete", produces = {"application/json;charset=UTF-8"})
    public String del(String id) {
        bookTypeService.deleteById(id);
        return "success";
    }
}