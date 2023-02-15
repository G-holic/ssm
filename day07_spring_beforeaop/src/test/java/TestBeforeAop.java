import cn.itcast.beforeaop.Calc;
import cn.itcast.beforeaop.CalcImpl;
import cn.itcast.beforeaop.MyProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:applicationContext_beforeAop.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestBeforeAop {

    @Autowired
    private Calc calc;
    @Test
    public void testBeforeAop(){
//        int add = calc.add(1, 6);
//        System.out.println("add = " + add);

        // 目标对象
        Calc calc = new CalcImpl();
        // 代理工具类
        MyProxy myProxy = new MyProxy(calc);
        // 获取代理对象
        Calc calcProxy = (Calc)myProxy.getProxyObject();
//        CalcImpl calcProxy = (CalcImpl)myProxy.getProxyObject();
        // 错误的CalcImpl  （代理对象与目标对象是兄弟关系，不能相互转换）
        System.out.println(calcProxy.getClass().getName());

        // 测试
//        calcProxy.add(1,5);
        calcProxy.div(5,2);
    }
}
