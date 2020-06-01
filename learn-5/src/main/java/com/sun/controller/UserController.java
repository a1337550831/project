package com.sun.controller;

import com.sun.pojo.User;
import com.sun.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;


    /**
     * 新增用户
     *
     * @param user 用户信息
     * @return 主键id
     */
    @RequestMapping(value = "/a/user",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addUser(User user){
        logger.info(" user is : "+user);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("status",0);
        try {
            Integer id  = userService.addUser(user);
            resultMap.put("data", id);
        }catch (Exception e){
            e.getMessage();
            logger.error(e.getMessage());
            resultMap.put("status", -1);
        }
        return resultMap;
    }


    /**
     * 删除用户
     *
     * @param id 主键id
     * @return 结果
     */
    @RequestMapping(value = "/a/user/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteUser(@PathVariable Long id){
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("status",0);
        try {
            Integer result  = userService.deleteUser(id);
            resultMap.put("data", result);
        }catch (Exception e){
            e.getMessage();
            logger.error(e.getMessage());
            resultMap.put("status", -1);
        }
        return resultMap;
    }






    /**
     * 更改用户
     *
     * @param id 用户id
     * @param user 用户信息
     * @return 结果
     */
    @RequestMapping(value = "/a/user",method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> updateUser(User user){
        logger.info("user is : "+user);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("status",0);
        try {
            Integer result  = userService.updateUser(user);
            resultMap.put("data", result);
        }catch (Exception e){
            e.getMessage();
            logger.error(e.getMessage());
            resultMap.put("status", -1);
        }
        return resultMap;
    }


    /**
     * 查询用户详情
     *
     * @param id 用户id
     * @return 结果
     */
    @RequestMapping(value = "/a/user/{id}",method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable Long id){
        logger.info("你好世界");
        System.out.println("---------------------------------------------------------");
        User user = userService.selectObject(id);

        User user1 = new User();
        user1.setId(0L);
        user1.setName("");
        user1.setQq("");
        user1.setType(0);
        user1.setTime(0L);
        user1.setLink("");
        user1.setCreateAt(0L);
        user1.setCreateBy(0L);
        user1.setUpdateAt(0L);
        user1.setUpdateBy(0L);


        logger.info("user is : "+user);
        return  user;
    }

    /**
     * 查询用户详情
     *
     * @param id 用户id
     * @return 结果
     */
    @RequestMapping(value = "/a/user/test/{id}",method = RequestMethod.GET)
    @ResponseBody
    public User getUserTest(@PathVariable Long id){
        logger.info("你好世界");
        System.out.println("---------------------------------------------------------");
        User user = userService.selectObject(id);

        User user1 = new User();
        user1.setId(0L);
        user1.setName("");
        user1.setQq("");
        user1.setType(0);
        user1.setTime(0L);
        user1.setLink("");
        user1.setCreateAt(0L);
        user1.setCreateBy(0L);
        user1.setUpdateAt(0L);
        user1.setUpdateBy(0L);


        logger.info("user is : "+user);
        return  user;
    }



    /**
     * 查询用户列表
     *
     * @return 结果
     */
    @RequestMapping(value = "/a/user/list/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getUserList(@PathVariable Long id,
                                           String name,
                                           @RequestParam("test") String dog){
        Long time = System.currentTimeMillis();
        logger.info("id is : "+id +" name is : "+name+"  gog is : "+dog);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("status",0);
        try {
            List<User> userList  = userService.selectList();
            logger.info("time = "+(System.currentTimeMillis()-time)+"  userlist size is "+userList.size());
            resultMap.put("data", userList);
        }catch (Exception e){
            e.getMessage();
            logger.error(e.getMessage());
            resultMap.put("status", -1);
        }
        return resultMap;
    }
}
