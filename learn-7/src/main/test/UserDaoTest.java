import com.sun.dao.ClassifyMapper;
import com.sun.pojo.Classify;
import com.sun.serivce.ClassifyService;
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserDaoTest {

    @Autowired
    private ClassifyService classifyService;

    Logger logger = Logger.getLogger(UserDaoTest.class);


    @Test
    public void add(){
        Classify classify = new Classify();
        classify.setName("添加测试service成");
        classify.setPid(0L);
        classify.setCreateAt(0L);
        classify.setCreateBy(0L);
        classify.setUpdateAt(0L);
        classify.setUpdateBy(0L);
        classifyService.insert(classify);
        logger.info("id is : "+classify.getId());
    }





}
