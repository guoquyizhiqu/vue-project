package com.liu.controller;


import com.github.pagehelper.PageInfo;
import com.liu.model.BookInfo;
import com.liu.service.BookInfoService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by liu on 2018/3/26.
 */
@RestController
@RequestMapping(value = "/book-info")
public class BookInfoController {

    @Autowired
    private BookInfoService bookInfoService;

    @ResponseBody
    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public String addBookInfo(HttpServletRequest req, BookInfo bookInfo) {
        System.out.print("------------------>");
       /* System.out.print("------------------>"+bookInfo.toString());
      bookInfoService.addBookInfo(bookInfo);*/
        return "success";
    }

    @RequestMapping(value = "/test", produces = {"application/json;charset=UTF-8"})
    public String test(HttpServletRequest req, BookInfo bookInfo) {
        System.out.println("-----test---------");
        return "success";
    }

    @RequestMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public PageInfo findAllBookInfo(int pageNum, int pageSize, String aa) {
        System.out.print("-------findAllBookInfo--------------------------->");
        List<BookInfo> list = bookInfoService.findAllBookInfo(pageNum, pageSize);
        return new PageInfo(list);
       /* return new PageInfo();*/
    }
}