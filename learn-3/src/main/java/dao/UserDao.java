package dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.User;

import java.util.List;

public interface UserDao {

    /**
     * 新增
     * @param user
     * @return
     */
    public Integer addUser(User user);

    /**
     * 删除
     * @param id
     * @return
     */
    public Integer deleteUser(Long id);

    /**
     * 修改
     * @param user
     * @return
     */
    public Integer updateUser(User user);

    /**
     * 查询单个详情
     * @param id
     * @return
     */
    public User selectObject(@Param("id") Long id, @Param("name") String name);

    /**
     * 查询所有
     * @return
     */
    @Select("select * from user")
    public List<User> selectList();


}
