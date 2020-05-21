package util;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DataSourceUtil {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/learn?characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public static DriverManagerDataSource getTemplate(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(JDBC_DRIVER);
        dataSource.setUrl(DB_URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }

    public static ComboPooledDataSource getC3p0(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(JDBC_DRIVER);
            dataSource.setJdbcUrl(DB_URL);
            dataSource.setUser(USER);
            dataSource.setPassword(PASSWORD);
            dataSource.setInitialPoolSize(50);
            dataSource.setMaxPoolSize(100);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dataSource;
    }

    public static BasicDataSource getDbcp(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(JDBC_DRIVER);
        dataSource.setUrl(DB_URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);
        dataSource.setInitialSize(50);
        dataSource.setMaxActive(100);
        return dataSource;
    }

    public static DruidDataSource getDruid(){

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(JDBC_DRIVER);
        dataSource.setUrl(DB_URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);
        dataSource.setMaxActive(100);
        return dataSource;
    }
}
