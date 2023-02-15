package cn.itcast.dao.impl;

import cn.itcast.dao.DeptDao;
import cn.itcast.pojo.Dept;

public class DeptDaoImpl  implements DeptDao {
    @Override
    public void insertDept(Dept dept) {
        System.out.println("==>添加部门信息成功啦！！！");
    }
}
