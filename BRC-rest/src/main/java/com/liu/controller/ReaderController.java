package com.liu.controller;


import com.github.pagehelper.PageInfo;
import com.liu.model.Reader;
import com.liu.service.ReaderService;
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
@RequestMapping(value = "/reader")
public class ReaderController {

    @Autowired
    private ReaderService readerService;

    @ResponseBody
    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public String add(HttpServletRequest req, Reader reader) {
        reader.setCreateTime(new Date());
        readerService.add(reader);
        return "success";
    }

    @ResponseBody
    @PostMapping(value = "/edit", produces = {"application/json;charset=UTF-8"})
    public String edit(HttpServletRequest req, Reader reader) {
        reader.setUpdateTime(new Date());
        readerService.edit(reader);
        return "success";
    }


    @RequestMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public PageInfo findAllReader(int pageNum, int pageSize) {
        List<Reader> list = readerService.findAll(pageNum, pageSize);
        return new PageInfo(list);
    }

    @RequestMapping(value = "/detail", produces = {"application/json;charset=UTF-8"})
    public Reader findReader(String id) {
        Reader reader = readerService.findById(id);
        return reader;
    }

    @ResponseBody
    @PostMapping(value = "/delete", produces = {"application/json;charset=UTF-8"})
    public String del(String id) {
        readerService.deleteById(id);
        return "success";
    }
}