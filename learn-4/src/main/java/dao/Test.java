package dao;

//set注入
//构造注入




//使用注解

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import pojo.User;

import javax.annotation.Resource;

public class Test {

    private String name;



    public Test(String name) {
        this.name = name;
    }

    public Test(){
    }


    public void setName(String name) {
        this.name = name;
    }




    public void dogSay(){
        System.out.println("汪汪汪~");
    }
    public void catSay(){
        System.out.println("喵喵喵~");
    }
    public void getName(){
        System.out.println("你的名字是"+name);
    }

}
