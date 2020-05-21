package jdbc;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;

import dao.UserDao;
import dao.UserDaoImpl;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import pojo.User;
import util.DataSourceUtil;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {


    public static void main(String[] args) throws InterruptedException {
        //因为JDBCTemplate是依赖数据库连接池的，所以先构造连接池
        DataSource dataSource = DataSourceUtil.getDruid();

        //创建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Long time = System.currentTimeMillis();
        //初始化对象
        UserDao userDao = new UserDaoImpl();
        //新增
//        User user = new User();
//        user.setName("小红");
//        user.setQq("123456789");
//        user.setType(1);
//        user.setTime(time);
//        user.setLink("https://www.baidu.com");
//        user.setCreateAt(time);
//        user.setCreateBy(time);
//        user.setUpdateAt(time);
//        user.setUpdateBy(time);
//
//        Long id = userDao.addUser(jdbcTemplate,user);
//        System.out.println("插入返回主键id ："+id);

        //删除
        Long deleteId = 8L;
        Integer deleteResult = userDao.deleteUser(jdbcTemplate,deleteId);
        System.out.println("删除结果 ："+deleteResult);

        //查询
        User resultUser = userDao.selectObject(jdbcTemplate,8L);
        System.out.println(resultUser);

        //修改
//        resultUser.setQq("111111");
//        resultUser.setId(1L);
//        Integer updateResult = userDao.updateUser(jdbcTemplate,resultUser);
//        System.out.println(updateResult);

        //列表查询
//        List<User> userList = userDao.selectList(jdbcTemplate);
//        System.out.println("用户列表是："+userList);

    }
}
