package com.sun.dao;

import com.sun.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    List<Student> selectByParam(@Param("isHot") Integer isHot);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}