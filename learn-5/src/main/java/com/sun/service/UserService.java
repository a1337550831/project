package com.sun.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import com.sun.pojo.User;

import java.util.List;


public interface UserService {

    /**
     * 新增
     * @param user 用户
     * @return 结果
     */
    public Integer addUser(User user);

    /**
     * 删除
     * @param id 主键id
     * @return 结果
     */
    public Integer deleteUser(Long id);

    /**
     * 修改
     * @param user 用户
     * @return 结果
     */
    public Integer updateUser(User user);

    /**
     * 查询单个详情
     * @param id 主键id
     * @return 结果
     */
    public User selectObject(@Param("id") Long id);

    /**
     * 查询所有
     * @return 结果
     */
    public List<User> selectList();

}
