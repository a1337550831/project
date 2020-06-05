package com.sun.serivce.impl;

import com.sun.dao.ClassifyMapper;
import com.sun.pojo.Classify;
import com.sun.serivce.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassifyServiceImpl implements ClassifyService {
    @Autowired
    private ClassifyMapper classifyMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return classifyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Classify record) {
        return classifyMapper.insert(record);
    }

    @Override
    public int insertSelective(Classify record) {
        return classifyMapper.insertSelective(record);
    }

    @Override
    public Classify selectByPrimaryKey(Long id) {
        return classifyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Classify record) {
        return classifyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Classify record) {
        return classifyMapper.updateByPrimaryKey(record);
    }
}
