package cn.itcast.service;

import cn.itcast.mapper.EmployeeMapper;
import cn.itcast.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getEmployees() {

        return employeeMapper.selectAllEmps();
    }
}
