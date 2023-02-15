package cn.itcast.service.impl;

import cn.itcast.dao.DeptDao;

import cn.itcast.pojo.Dept;
import cn.itcast.service.DeptService;


public class DeptServiceImpl implements DeptService {
    private DeptDao deptDao; // = new DeptDaoImpl();

    @Override
    public void saveDept(Dept dept) {
        deptDao.insertDept(dept);
    }

    public void setDeptDao(DeptDao deptDao) {
        this.deptDao = deptDao;
    }
}
