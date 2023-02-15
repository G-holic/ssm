package cn.itcast.controller;

import cn.itcast.dao.DepartmentDao;
import cn.itcast.dao.EmployeeDao;
import cn.itcast.pojo.Department;
import cn.itcast.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;


    /**
     * 获取所有员工信息
     *
     * @return
     */
//    @RequestMapping(value = "/emps",method = RequestMethod.GET)
    @GetMapping("/emps")
    public String getAllEmps(Map<String, Object> map) {
        // 获取所有员工信息
        Collection<Employee> emps = employeeDao.getAll();
        // 将数据共享到域中
        map.put("emps", emps);

        return "emp_list";
    }

    /**
     * 跳转添加页面
     *
     * @return
     */
    @GetMapping("/toSaveEmp")
    public String toSaveEmp(Map<String, Object> map) {
        // 查询使所有的部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        // 共享到请求域中
        map.put("depts", departments);
        System.out.println("departments = " + departments);
        return "emp_save";
    }

    /**
     * 添加员工页面
     *
     * @return
     */
    @PostMapping("/emps")
    public String saveEmp(Employee employee) { // 直接pojo入参，Employee对象属性和emp_save.html的name属性一致即可
        System.out.println("employee = " + employee);
        // 添加员工
        employeeDao.save(employee);

        return "redirect:/emps"; // 重定向查询员工页面
    }

    /**
     * 实现删除员工信息
     *
     * @return
     */
    @DeleteMapping("/emps/{empId}")
    public String deleteEmp(@PathVariable("empId") Integer empId) {
        // 删除员工信息
        employeeDao.delete(empId);

        return "redirect:/emps";
    }


    /**
     * 跳转修改员工页面
     *
     * @return
     */
    @GetMapping("/toUpdateEmp/{empId}")
    public String toUpdateEmp(@PathVariable("empId") Integer empId,
                              Map<String, Object> map) {
        // 通过员工id获取员工信息
        Employee employee = employeeDao.get(empId);
        map.put("emp", employee);
        // 获取所有部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        map.put("depts", departments);

        return "emp_update";
    }


    /**
     * 实现修改功能
     *
     * @param employee
     * @return
     */
    @PutMapping("/emps")
    public String updateEmp(Employee employee) {
        System.out.println("employee = " + employee);
        // 调用修改
        employeeDao.save(employee);
        return "redirect:/emps";
    }


}
