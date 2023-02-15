package cn.itcast.service;

import cn.itcast.dao.BookShopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("cashierService")
public class CashierServiceImpl implements CashierService {


    @Autowired
    @Qualifier("bookShopService")
    private BookShopService bookShopService;
    /**
     * 去结账
     * 结账时，帐号余额支持买多少本书，就允许用户购买
     *
     * @param username
     * @param isbns
     */
    @Transactional
    public void checkOut(String username, List<String> isbns) {
        for (String isbn : isbns) {
            bookShopService.purchase(username, isbn);
        }
    }
}
