package com.sun.service.impl;

import com.sun.dao.ContentMapper;
import com.sun.pojo.Content;
import com.sun.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentMapper contentMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return contentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Content record) {
        return contentMapper.insert(record);
    }

    @Override
    public int insertSelective(Content record) {
        return contentMapper.insertSelective(record);
    }

    @Override
    public Content selectByPrimaryKey(Long id) {
        return contentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Content> selectByParam(Integer type) {
        return contentMapper.selectByParam(type);
    }

    @Override
    public int updateByPrimaryKeySelective(Content record) {
        return contentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Content record) {
        return contentMapper.updateByPrimaryKey(record);
    }
}
