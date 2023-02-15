import cn.itcast.config.SpringConfig;
import cn.itcast.dao.impl.DeptDaoImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test0Xml {


    @Test
    public void test0Xml(){
        // 创建容器对象
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("applicationContext.xml");

        // 使用AnnotationConfigApplicationContext容器对象
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        DeptDaoImpl deptDao = context.getBean("deptDao", DeptDaoImpl.class);
        System.out.println("deptDao = " + deptDao);
    }

}
