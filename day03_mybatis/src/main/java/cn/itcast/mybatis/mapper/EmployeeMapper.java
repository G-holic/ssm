package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.pojo.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    /**
     * 通过员工id获取员工信息及员工所属的部门信息
     */
    List<Employee> selectEmpAndDeptByEmpId(int empId);

    /**
     * 通过员工id获取员工信息及员工所属的部门信息
     */
    Employee selectEmpAndDeptByEmpIdAssociation(int empId);

    /**
     * 通过员工id获取员工信息及员工所属的部门信息【分部查询】
     *      1.通过员工id获取员工信息【id、last_name、email、salary、dept_id】
     *      2.再通过部门id获取部门信息【dept_id、dept_name】
     */
    Employee selectEmpAndDeptByEmpIdAssociationStep(int empId);


    /**
     * 通过部门Id获取员工信息
     * @param deptId
     * @return
     */
    List<Employee> selectEmpByDeptId(int deptId);



}
