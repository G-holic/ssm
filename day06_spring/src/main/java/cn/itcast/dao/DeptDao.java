package cn.itcast.dao;

import cn.itcast.pojo.Dept;

public interface DeptDao {

    /**
     * 添加部门信息
     * @param dept
     */
    public void insertDept(Dept dept);
}
