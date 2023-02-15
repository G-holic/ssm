package cn.itcast.dao.impl;

import cn.itcast.dao.DeptDao;
import cn.itcast.pojo.Dept;
import org.springframework.stereotype.Repository;


@Repository("deptDao2")
public class DeptDaoImpl2 implements DeptDao {
    @Override
    public void insertDept(Dept dept) {
        System.out.println("==>DeptDapImpl22222222222！！！");
    }
}
