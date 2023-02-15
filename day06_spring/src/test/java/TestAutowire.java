import cn.itcast.pojo.Dept;
import cn.itcast.service.DeptService;
import cn.itcast.service.impl.DeptServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAutowire {

    @Test
    public void testAutowire(){
        // 创建容器对象
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext_autowire.xml");

        DeptServiceImpl deptService = context.getBean("deptService", DeptServiceImpl.class);

        deptService.saveDept(new Dept());
    }
}
