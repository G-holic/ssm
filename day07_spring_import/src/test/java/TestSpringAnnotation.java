import cn.itcast.controller.DeptController;
import cn.itcast.dao.DeptDao;
import cn.itcast.dao.impl.DeptDaoImpl;
import cn.itcast.pojo.Dept;
import cn.itcast.service.impl.DeptServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringAnnotation {

    /**
     * 测试四个注解【将对象装配到IOC容器中】
     */
    @Test
    public void testSpringAnnotation(){
        // 创建容器对象
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

//        Dept dept = context.getBean("dept", Dept.class);
        DeptDao deptDao = context.getBean("deptDao", DeptDaoImpl.class);
        DeptServiceImpl deptService = context.getBean("deptService", DeptServiceImpl.class);
        DeptController deptController = context.getBean("deptController", DeptController.class);
//
//        System.out.println("dept = " + dept);
        System.out.println("deptDao = " + deptDao);
        System.out.println("deptService = " + deptService);
        System.out.println("deptController = " + deptController);
    }

    /**
     * 测试装配对象中的属性
     */

    @Test
    public void testAnnotationProperty(){
        // 创建容器对象
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

//        DeptDaoImpl deptDao = context.getBean("deptDao", DeptDaoImpl.class);
        DeptServiceImpl deptService = context.getBean("deptService", DeptServiceImpl.class);

        deptService.saveDept(new Dept());


        Dept dept = context.getBean("dept", Dept.class);
        System.out.println("dept = " + dept);
    }
}
