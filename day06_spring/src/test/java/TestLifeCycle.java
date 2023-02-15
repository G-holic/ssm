import cn.itcast.pojo.Student;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLifeCycle {

    @Test
    public void testLifeCycle(){
        // 创建容器对象
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext_lifeCycle.xml");

        Student student = context.getBean("student", Student.class);
        System.out.println("4.使用student：" + student);

        context.close(); // ConfigurableApplicationContext提供了关闭的方法
    }
}
