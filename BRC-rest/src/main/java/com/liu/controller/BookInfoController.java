package com.liu.controller;


import com.github.pagehelper.PageInfo;
import com.liu.model.BookInfo;
import com.liu.service.BookInfoService;
import com.liu.tools.ActionContextUtils;
import com.liu.tools.MyConstant;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        bookInfo.setBorrowNumber(0);
        bookInfoService.addBookInfo(bookInfo);
        return "success";
    }

    @ResponseBody
    @PostMapping(value = "/edit", produces = {"application/json;charset=UTF-8"})
    public String edit(HttpServletRequest req, BookInfo bookInfo) {
        bookInfo.setUpdateTime(new Date());
        bookInfoService.edit(bookInfo);
        return "success";
    }


    @RequestMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public PageInfo findAllBookInfo(int pageNum, int pageSize) {
        Map<String, Object> queryMap = new HashMap<String, Object>();
        String borrowingStatus = ActionContextUtils.getParameter("borrowingStatus");
        if(borrowingStatus != null && !borrowingStatus.equals(""))
        {
            queryMap.put("borrowingStatus", borrowingStatus);
        }
        List<BookInfo> list = bookInfoService.findAllBookInfo(pageNum, pageSize, queryMap);
        return new PageInfo(list);
    }

    @RequestMapping(value = "/detail", produces = {"application/json;charset=UTF-8"})
    public BookInfo findBookInfo(String id) {
        BookInfo bookInfo = bookInfoService.findById(id);
        return bookInfo;
    }

    @ResponseBody
    @PostMapping(value = "/delete", produces = {"application/json;charset=UTF-8"})
    public String del(String id) {
        bookInfoService.deleteById(id);
        return "success";
    }
}