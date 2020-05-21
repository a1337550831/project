package run;

import com.alibaba.druid.pool.DruidDataSource;
import dao.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class Run {

    public int[] twoSum(int[] nums, int target) {


        Map<Integer,Integer> map  = new HashMap<Integer, Integer>();
        for(int i = 0;i<nums.length;i++ ){
            map.put(nums[i],i);
        }
        for (int i = 0;i<nums.length;i++){
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        return nums;
    }




    public static void main(String[] args) {
        //读取配置文件，初始化IOC容器
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Test test = (Test) applicationContext.getBean("test");
//        test.getName();


        System.out.println("hello word!");

    }
}
