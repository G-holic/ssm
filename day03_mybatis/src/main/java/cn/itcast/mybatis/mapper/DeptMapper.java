package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.pojo.Dept;

public interface DeptMapper {

    /**
     * 通过部门id获取部门信息【dept_id、dept_name】
     * @param deptId
     * @return
     */
    Dept selectDeptByDeptId(int deptId);


    /**
     * 通过部门id获取部门信息，及部门所属员工信息
     */
    Dept selectDeptAndEmpByDeptId(int deptId);


    /**
     * 通过部门id获取部门信息，及部门所属员工信息【分部查询】
     *          1.通过部门id获取部门信息
     *          2.通过部门id获取员工信息
     */
    Dept selectDeptAndEmpByDeptIdStep(int deptId);

}
