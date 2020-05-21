package dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pojo.User;

import java.io.InputStream;
import java.util.List;

public class UserDaoTest {

    private UserDao userDao;
    private SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {
        // mybatis-config.xml
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取sqlSession
        sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        //使用动态代理
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @Test
    public void addUser() {
        Long time = System.currentTimeMillis();
        User user = new User();
        user.setName("天天");
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
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void deleteUser() {
        Integer result = userDao.deleteUser(10L);
        System.out.println(result);
        sqlSession.commit();
        sqlSession.close();

    }



//    @Test
//    public void updateUser() {
//        User user = userDao.selectObject(11L);
//
//        System.out.println("user is : "+user);
//        user.setName("你好明天111111111111");
//
//        Integer result = userDao.updateUser(user);
//        User resultUser = userDao.selectObject(11L);
//        System.out.println("result is : "+resultUser);
//        sqlSession.commit();
//    }

    @Test
    public void selectObject() {
        User user = userDao.selectObject(11L,"你好明天111111111111");
        System.out.println(user);
        sqlSession.commit();
    }

    @Test
    public void selectList() {
        List<User> userList = userDao.selectList();
        System.out.println(userList);
        sqlSession.commit();
    }


    /**
     * 不使用动态代理
     * 使用动态代理
     * 配置属性
     * mapper属性
     */
}