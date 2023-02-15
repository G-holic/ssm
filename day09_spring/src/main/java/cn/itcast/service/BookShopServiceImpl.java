package cn.itcast.service;

import cn.itcast.dao.BookShopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;
import org.springframework.lang.NonNullFields;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    @Qualifier("bookShopDao")
    private BookShopDao bookShopDao;

    /**
     * 买书->查询book的价格->修改库存->修改余额
     *      1.去结账时判断余额是否充足，余额不足：一本书都不能买
     *      2.去结账时判断余额是否充足，余额不足：最后导致余额不足的那本书，不让购买
     */

    @Transactional(propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.REPEATABLE_READ,
            timeout = 3,
            readOnly = false,
            noRollbackFor = ArithmeticException.class
    ) // 2.
            // noRollbackFor = ArithmeticException.class 设置算数异常不回滚，后续会继续执行
//    @Transactional(propagation = Propagation.REQUIRED) // 1.
    public void purchase(String username, String isbn) {
        // 查询Book价格
        Integer price = bookShopDao.findBookPriceByIsbn(isbn);
        System.out.println("哈哈哈哈！"); // debug，边debug边手动修改数据表的数据，查看现象。（测试隔离级别）
//        Integer price2 = bookShopDao.findBookPriceByIsbn(isbn);

        /*try {
            int i = 1/0;// 故意给个异常
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        //  模拟事务超时（测试timeout）
        /*try {
            Thread.sleep(5000); // 让他等5秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        // 修改库存
        bookShopDao.updateBookStock(isbn);
        // 修改余额
        bookShopDao.updateUserAccount(username, price);
    }

}
