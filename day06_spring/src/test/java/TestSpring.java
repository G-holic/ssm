import cn.itcast.factory.MyFactoryBean;
import cn.itcast.pojo.Dept;
import cn.itcast.pojo.Employee;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    /**
     * 测试Spring依赖注入
     */
    @Test
    public  void  testIOC(){
        // 创建容器对象
        ApplicationContext iocObj = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 测试外部bean
//        Employee chai = iocObj.getBean("empChai", Employee.class);
//        System.out.println("chai = " + chai);

        // 测试内部bean-获取empXin
//        Employee empXin = iocObj.getBean("empXin", Employee.class);
//        System.out.println("empXin = " + empXin);
//        System.out.println("empXin.getDept() = " + empXin.getDept());


        // 获取dept1
//        Dept dept1 = iocObj.getBean("dept1", Dept.class);
//        System.out.println("dept1 = " + dept1);

        // 测试List及提取List
//        Dept dept3 = iocObj.getBean("dept3", Dept.class);
//        System.out.println("dept3 = " + dept3);

//        Dept dept4 = iocObj.getBean("dept4", Dept.class);
//        System.out.println("dept4 = " + dept4);


        // 测试Map及提取Map
//        Dept dept5 = iocObj.getBean("dept5", Dept.class);
//        System.out.println("dept5 = " + dept5);

        Dept dept6 = iocObj.getBean("dept6", Dept.class);
        System.out.println("dept6 = " + dept6);

    }
    /**
     * 测试druidDatasource 第三方bean
     */
    @Test
    public void testDruidDataSource() throws Exception{
        // 获取容器对象
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext_druid.xml");

        DruidDataSource dataSource = ioc.getBean("dataSource", DruidDataSource.class);
        System.out.println("dataSource = " + dataSource);

        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println("connection = " + connection);
    }

    /**
     * 测试FactoryBean
     *
     */
    @Test
    public void testFactoryBean(){
        // 获取容器对象
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext_factorybean.xml");

        Dept myFactoryBean = ioc.getBean("myFactoryBean", Dept.class);
        System.out.println("myFactoryBean = " + myFactoryBean);
    }
}
