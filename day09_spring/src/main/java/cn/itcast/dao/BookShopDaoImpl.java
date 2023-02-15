package cn.itcast.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao{

    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    /**
     * 根据书号查询书的价格
     * @param isbn
     * @return
     */
    @Override
    public Integer findBookPriceByIsbn(String isbn) {
        String sql = "select price from book where isbn=?";
        return jdbcTemplate.queryForObject(sql,Integer.class,isbn);
    }

    /**
     *根据书号修改书的库存（需求：每次只能卖一本书，入库存<=0,则抛出异常）
     * @param isbn
     */
    @Override
    public void updateBookStock(String isbn) {
        String sql = "update book_stock set stock=stock-1 where isbn=?";
        jdbcTemplate.update(sql,isbn);

        // 验证库存
        String sql2 = "select stock from book_stock where isbn=?";
        Integer newStock = jdbcTemplate.queryForObject(sql2, Integer.class, isbn);
        if (newStock<=0){
            throw new RuntimeException("库存不足");
        }
    }

    /**
     * 根据书的价格修改用户的余额（需求：如果余额不足，则抛出异常）
     * @param username
     * @param price
     */
    @Override
    public void updateUserAccount(String username, Integer price) {
        // 检查余额是否充足
        // 通过用户名查询  用户余额
        String sql = "select balance from account where username=?";
        Integer balance = jdbcTemplate.queryForObject(sql, Integer.class, username);
        if (balance < price){
            throw new RuntimeException("余额不足！");
        }
        // 修改用余额
        String sql2 = "update account set balance = balance-? where username=?";
        jdbcTemplate.update(sql2,price,username);
    }
}
