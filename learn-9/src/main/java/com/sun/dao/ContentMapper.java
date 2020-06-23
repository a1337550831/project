package com.sun.dao;

import com.sun.pojo.Content;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Content record);

    int insertSelective(Content record);

    Content selectByPrimaryKey(Long id);

    List<Content> selectByParam(@Param("type") Integer type);

    int updateByPrimaryKeySelective(Content record);

    int updateByPrimaryKey(Content record);
}