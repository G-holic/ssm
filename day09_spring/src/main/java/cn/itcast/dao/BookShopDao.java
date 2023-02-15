package cn.itcast.dao;

public interface BookShopDao {

    // 1.根据书号查询书的价格
    Integer findBookPriceByIsbn(String isbn);
    // 2.根据书号修改书的库存（需求：每次只能卖一本书，入库存<=0,则抛出异常）
    void updateBookStock(String isbn);
    // 3.根据书的价格修改用户的余额（需求：如果余额不足，则抛出异常）
    void updateUserAccount(String username, Integer price);
}
