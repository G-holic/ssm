import cn.itcast.pojo.Dept;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestScope {

    @Test
    public  void testScope(){
        // 创建容器对象
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext_beanscope.xml");

        Dept dept = context.getBean("dept", Dept.class);
        Dept dept1 = context.getBean("dept", Dept.class);

        System.out.println("是否为一个对象？" + (dept == dept1));

    }
}
