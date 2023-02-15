package cn.itcast.service;

import cn.itcast.dao.DeptDao;
import cn.itcast.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("deptService")
public class DeptServiceImpl implements DeptService{
    @Autowired
    @Qualifier("deptDaoImpl")
    private DeptDao deptDao;

    @Override
    public List<Dept> getAllDepts() {
        List<Dept> depts = deptDao.selectAllDepts();
        return depts;
    }
}
