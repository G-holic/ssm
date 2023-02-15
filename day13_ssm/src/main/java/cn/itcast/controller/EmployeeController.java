package cn.itcast.controller;

import cn.itcast.pojo.Employee;
import cn.itcast.service.EmployeeService;
import cn.itcast.util.PageUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    @Qualifier("employeeService")
    private EmployeeService employeeService;

    @GetMapping("/emps/{pageNum}")
    public String getAllEmps(Map<String, Object> map,
                             @PathVariable("pageNum") Integer pageNum,
                             HttpServletRequest request) {
        int pn=1;
        if (pageNum!=null){
            pn = pageNum;
        }
        // 查询之前，开启分页
        Page<Object> objects = PageHelper.startPage(pn, 3);
        List<Employee> employees = employeeService.getEmployees();
        // 封装分页
        PageInfo<Employee> pageInfo = new PageInfo<>(employees,5);
        // 使用工具类，获取分页信息
        String pageRs = PageUtils.getPageInfo(pageInfo, request);
        // 将数据共享到域中
        map.put("pageRs",pageRs);
        map.put("emps", employees);
        for (Employee employee1 : employees) {
            System.out.println("employee1 = " + employee1);
        }
        return "emp_list";
    }
}
