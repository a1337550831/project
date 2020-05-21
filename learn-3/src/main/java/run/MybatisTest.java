package run;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.User;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {

    public static void main(String[] args) throws IOException {
        // 指定全局配置文件
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = sqlSession.selectOne("dao.UserDao.selectObject", 10);
        System.out.println(user);

    }


    /**
     * 1)配置mybatis-config.xml 全局的配置文件 (1、数据源，2、外部的mapper)
     * 2)创建SqlSessionFactory
     * 3)通过SqlSessionFactory创建SqlSession对象
     * 4)通过SqlSession操作数据库 CRUD
     * 5)调用session.commit()提交事务
     * 6)调用session.close()关闭会话
     * ————————————————
     *
     *
     */
}


