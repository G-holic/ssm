package cn.itcast.service;

import cn.itcast.pojo.Dept;

import java.util.List;

public interface DeptService {

    /**
     * 查询所有部门信息
     * @return
     */

    public List<Dept> getAllDepts();
}
