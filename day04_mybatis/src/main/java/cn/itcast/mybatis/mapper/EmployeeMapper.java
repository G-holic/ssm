package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {

    /**
     * 按条件查询员工信息【多个条件不确定（employee）】if-where
     */
    List<Employee> selectEmployeeByOpr(Employee employee);

    /**
     * 按条件查询员工信息【条件不确定（employee）】trim
     */
    List<Employee> selectEmployeeByOprTrim(Employee employee);

    /**
     * 按条件修改员工信息【条件不确定】
     * @param employee
     */
    void updateEmpByOpr(Employee employee);

    /**
     * 按条件查询员工信息【单个条件不确定（employee）】choose
     */
    List<Employee> selectEmpByOneOpr(Employee employee);


    /**
     * 通过多个id获取员工信息【ids：员工id的集合】
     * @param ids
     * @return
     */
    List<Employee> selectEmpByIds(@Param("ids") List<Integer> ids);

    /**
     * 批量添加员工信息
     * @param employees
     */
    void batchInsertEmp(@Param("employees") List<Employee> employees);
}
