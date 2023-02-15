package cn.itcast.service;

import cn.itcast.pojo.Employee;

import java.util.List;

public interface EmployeeService {

    /**
     * 查询说有员工信息
     * @param
     * @return
     */
    List<Employee> getEmployees();
}
