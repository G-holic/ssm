import cn.itcast.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    @Test
    public void testSpring(){
        // 使用Spring之前
//        Student student = new Student();

        // 使用Spring之后
        // 创建容器对象
        ApplicationContext iocObj = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 通过容器对象，获取需要对象
        // 方式一
//        Student stuLisi = (Student)iocObj.getBean("stuLisi");
//        System.out.println("stuLisi = " + stuLisi);

//        Student bean = iocObj.getBean(Student.class);
////        System.out.println("bean = " + bean); // 多个对象报错

        // 方式三 （推荐使用）
//        Student stuLisi = iocObj.getBean("stuLisi", Student.class);
//        System.out.println("stuLisi = " + stuLisi);

//        Student stuWangwu = iocObj.getBean("stuWangwu", Student.class);
//        System.out.println("stuWangwu = " + stuWangwu);

//        Student zhaoliu = iocObj.getBean("stuZhaoliu", Student.class);
//        System.out.println("zhaoliu = " + zhaoliu);

        Student zhaoliu = iocObj.getBean("stuXiaoer", Student.class);
        System.out.println("xiaoer = " + zhaoliu);
    }
}
