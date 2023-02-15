import cn.itcast.service.BookShopService;
import cn.itcast.service.BookShopServiceImpl;
import cn.itcast.service.CashierService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@ContextConfiguration(locations = "classpath:applicationContext_transactionmanager.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestTransactionManager {


    /**
     * 测试声明式事务管理的基本使用
     */
    /*@Autowired
    @Qualifier("bookShopService")
    private BookShopService bookShopService;*/

    @Test
    public void testTransactionManager(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext_transactionmanager.xml");
        BookShopService bookShopService = context.getBean("bookShopService", BookShopService.class);
        // 添加声明式事务管理之后，获取的是代理对象，代理对象不能转换为目标对象【实现类】
//        BookShopService bookShopService = context.getBean("bookShopService", BookShopServiceImpl.class); // 报错
//        bookShopService.purchase("chenlong","1002");
        bookShopService.purchase("chenlong","1002");
    }

    /**
     * 测试声明式事务管理的属性
     */
    @Autowired
    @Qualifier("cashierService")
    private CashierService cashierService;

    @Test
    public void testTransactionAttr(){

        List<String> ids = new ArrayList<>();
        ids.add("1001");
        ids.add("1002");
        cashierService.checkOut("chenlong",ids);
    }

}
