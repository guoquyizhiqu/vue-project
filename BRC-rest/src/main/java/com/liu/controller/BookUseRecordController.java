package com.liu.controller;


import com.github.pagehelper.PageInfo;
import com.liu.model.BookUseRecord;
import com.liu.service.BookUseRecordService;
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
    @RequestMapping(value = "/book-use-record")
public class BookUseRecordController {

    @Autowired
    private BookUseRecordService bookUseRecordService;

    @ResponseBody
    @PostMapping(value = "/borrow", produces = {"application/json;charset=UTF-8"})
    public String add(HttpServletRequest req, BookUseRecord bookUseRecord) {
        bookUseRecordService.add(bookUseRecord);
        return "success";
    }

    @ResponseBody
    @PostMapping(value = "/return-book", produces = {"application/json;charset=UTF-8"})
    public String returnBook(String id) {
        bookUseRecordService.returnById(id);
        return "success";
    }

    @ResponseBody
    @PostMapping(value = "/edit", produces = {"application/json;charset=UTF-8"})
    public String edit(HttpServletRequest req, BookUseRecord bookUseRecord) {
        bookUseRecord.setUpdateTime(new Date());
        bookUseRecordService.edit(bookUseRecord);
        return "success";
    }


    @RequestMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public PageInfo findAllBookUseRecord(int pageNum, int pageSize) {
        Map<String, Object> queryMap = new HashMap<String, Object>();
        String status = ActionContextUtils.getParameter("status");
        if(status != null && !status.equals(""))
        {
            queryMap.put("status", status);
        }
        List<BookUseRecord> list = bookUseRecordService.findAll(pageNum, pageSize, queryMap);
        return new PageInfo(list);
    }

    @RequestMapping(value = "/detail", produces = {"application/json;charset=UTF-8"})
    public BookUseRecord findBookUseRecord(String id) {
        BookUseRecord bookUseRecord = bookUseRecordService.findById(id);
        return bookUseRecord;
    }

    @ResponseBody
    @PostMapping(value = "/delete", produces = {"application/json;charset=UTF-8"})
    public String del(String id) {
        bookUseRecordService.deleteById(id);
        return "success";
    }
}