import cn.itcast.aop.Calc;
import cn.itcast.aop.CalcImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
    @Test
    public  void testAop(){
        // 创建容器对象
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext_aop.xml");

        Calc calc = context.getBean("calc", Calc.class);
        System.out.println(calc.getClass().getName());
        // 错误的，代理对象不能转换为目标对象【代理对象与目标对象是兄弟关系】
//        CalcImpl calc1 = context.getBean("calc", CalcImpl.class);

        int add = calc.add(1, 5);
        System.out.println("==========================================");
//        int div = calc.div(5, 2);
//        System.out.println("div = " + div);
    }


}
