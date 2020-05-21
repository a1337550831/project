package com.sun.service.impl;

import com.sun.dao.UserDao;
import com.sun.pojo.User;
import com.sun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public Integer addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public Integer deleteUser(Long id) {
        return userDao.deleteUser(id);
    }

    @Override
    public Integer updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public User selectObject(Long id) {
        return userDao.selectObject(id);
    }

    @Override
    public List<User> selectList() {
        return userDao.selectList();
    }
}
