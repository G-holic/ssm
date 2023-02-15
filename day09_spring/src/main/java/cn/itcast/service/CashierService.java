package cn.itcast.service;

import java.util.List;

public interface CashierService {
    void checkOut(String username, List<String> isbns);
}
