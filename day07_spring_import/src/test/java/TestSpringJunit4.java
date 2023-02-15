import cn.itcast.pojo.Dept;
import cn.itcast.service.DeptService;
import cn.itcast.service.impl.DeptServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSpringJunit4 {

    @Autowired
    private  DeptService deptService;

    @Test
    public void testService(){
        // 创建容器对象
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        DeptService deptService = context.getBean("deptService", DeptServiceImpl.class);
//        System.out.println("deptService = " + deptService);

        deptService.saveDept(new Dept());
    }
}
