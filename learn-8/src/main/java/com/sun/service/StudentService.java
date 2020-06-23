package com.sun.service;

import com.sun.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    List<Student> selectByParam(Integer isHot);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}
