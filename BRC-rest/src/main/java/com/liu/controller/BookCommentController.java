package com.liu.controller;


import com.github.pagehelper.PageInfo;
import com.liu.model.BookComment;
import com.liu.service.BookCommentService;
import com.liu.tools.ActionContextUtils;
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
    @RequestMapping(value = "/book-comment")
public class BookCommentController {

    @Autowired
    private BookCommentService bookCommentService;

    @ResponseBody
    @PostMapping(value = "/borrow", produces = {"application/json;charset=UTF-8"})
    public String add(HttpServletRequest req, BookComment bookComment) {
        bookCommentService.add(bookComment);
        return "success";
    }

    @ResponseBody
    @PostMapping(value = "/edit", produces = {"application/json;charset=UTF-8"})
    public String edit(HttpServletRequest req, BookComment bookComment) {
        bookComment.setUpdateTime(new Date());
        bookCommentService.edit(bookComment);
        return "success";
    }


    @RequestMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public PageInfo findAllBookComment(int pageNum, int pageSize) {
        Map<String, Object> queryMap = new HashMap<String, Object>(0);
        String status = ActionContextUtils.getParameter("status");
        if(status != null && !status.equals(""))
        {
            queryMap.put("status", status);
        }
        List<BookComment> list = bookCommentService.findAll(pageNum, pageSize, queryMap);
        return new PageInfo(list);
    }

    @RequestMapping(value = "/detail", produces = {"application/json;charset=UTF-8"})
    public BookComment findBookComment(String id) {
        BookComment bookComment = bookCommentService.findById(id);
        return bookComment;
    }

    @ResponseBody
    @PostMapping(value = "/delete", produces = {"application/json;charset=UTF-8"})
    public String del(String id) {
        bookCommentService.deleteById(id);
        return "success";
    }
}