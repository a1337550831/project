package dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pojo.User;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    Logger logger = Logger.getLogger(UserDaoTest.class);


    @Test
    public void addUser() {
        Long time = System.currentTimeMillis();
        User user = new User();
        user.setName("天天向上");
        user.setQq("123456789");
        user.setType(1);
        user.setTime(time);
        user.setLink("www.baidu.com");
        user.setCreateAt(time);
        user.setCreateBy(time);
        user.setUpdateAt(time);
        user.setUpdateBy(time);
        Integer result = userDao.addUser(user);
        System.out.println(result);
        System.out.println(user.getId());
    }

    @Test
    public void deleteUser() {
        Integer result = userDao.deleteUser(10L);
        System.out.println(result);
    }

    @Test
    public void updateUser() {
        User user = userDao.selectObject(11L);
        System.out.println("user is : " + user);
        user.setName("你好明天111111111111");
        Integer result = userDao.updateUser(user);
        User resultUser = userDao.selectObject(11L);
        System.out.println("result is : " + resultUser);
    }

    @Test
    public void selectObject() {
        User user = userDao.selectObject(11L);
        System.out.println();
        System.out.println(user);
    }

    @Test
    public void selectList() {
        List<User> userList = userDao.selectList();
        System.out.println(userList);
    }
}
