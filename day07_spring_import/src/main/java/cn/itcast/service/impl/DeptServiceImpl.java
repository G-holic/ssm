package cn.itcast.service.impl;

import cn.itcast.dao.DeptDao;
import cn.itcast.pojo.Dept;
import cn.itcast.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "deptService")
public class DeptServiceImpl implements DeptService {

//    @Autowired(required = false)
    // beanId: deptDao&deptDao2
    @Autowired
    @Qualifier("deptDao2") // 必须配合@Autowired使用
    private DeptDao deptDao;

    @Override
    public void saveDept(Dept dept) {
        deptDao.insertDept(dept);
    }
}
