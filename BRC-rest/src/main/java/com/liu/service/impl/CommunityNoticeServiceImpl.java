package com.liu.service.impl;

import com.github.pagehelper.PageHelper;
import com.liu.dao.CommunityNoticeMapper;
import com.liu.model.CommunityNotice;
import com.liu.service.CommunityNoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liu on 2018/3/26.
 */
@Service(value = "communityNoticeService")
public class CommunityNoticeServiceImpl implements CommunityNoticeService{

    @Resource
    CommunityNoticeMapper communityNoticeDao;

    @Override
    public Boolean add(CommunityNotice communityNotice) {
        Boolean flag = communityNoticeDao.save(communityNotice);
        return flag;
    }

    @Override
    public Boolean edit(CommunityNotice communityNotice) {
        Boolean flag = communityNoticeDao.edit(communityNotice);
        return flag;
    }

    @Override
    public Boolean deleteById(String id) {
        Boolean flag = communityNoticeDao.deleteById(id);
        return flag;
    }

    @Override
    public CommunityNotice findById(String id) {
        return communityNoticeDao.selectByPrimaryKey(id);
    }

    /*
   * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
   * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
   * pageNum 开始页数
   * pageSize 每页显示的数据条数
   * */
    @Override
    public List<CommunityNotice> findAll(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<CommunityNotice> list = communityNoticeDao.selectAll();

        return list;
    }
}
