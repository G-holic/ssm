package cn.itcast.dao;

import cn.itcast.pojo.Dept;

import java.util.List;

public interface DeptDao {

    /**
     * 查询所有部门信息
     * @return
     */
    public List<Dept> selectAllDepts();
}
