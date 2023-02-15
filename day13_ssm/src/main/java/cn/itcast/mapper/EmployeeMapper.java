package cn.itcast.mapper;

import cn.itcast.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // 容器中自动装配了代理对象(可以不注解，也可以保留)
public interface EmployeeMapper {

    /**
     * 获取所有员工信息
     */

    public List<Employee> selectAllEmps();
}
