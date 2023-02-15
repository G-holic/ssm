package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class EmployeeController {

    private final static String SUCCESS = "success";

    /**
     * 添加员工信息
     *
     * @return
     */
    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String saveEmp() {
        System.out.println("==>添加员工信息！！！");
        return SUCCESS;
    }

    /**
     * 获取员工信息
     *
     * @param empId
     * @return
     */
    @RequestMapping(value = "/emp/{empId}", method = RequestMethod.GET)
    public String getEmpById(@PathVariable(value = "empId") Integer empId) {
        System.out.println("==>获取员工信息！！！empId:" + empId);
        return SUCCESS;
    }

    /**
     * 修改员工信息
     *
     * @return
     */
    @RequestMapping(value = "emp", method = RequestMethod.PUT)
    public String updateEmp() {
        System.out.println("==>修改员工信息!!!");
        return SUCCESS;
    }

    /**
     * 删除员工信息
     *
     * @param empId
     * @return
     */
    @RequestMapping(value = "/emp/{empId}", method = RequestMethod.DELETE)
    public String deleteEmpById(@PathVariable(value = "empId") Integer empId) {
        // @PathVariable: required:false：表示当前参数不必须入参，如未入参，装配null值
                        // defaultValue=...:作用：当装配数值为null时，指定当前defaultValue默认值
        System.out.println("==>删除员工信息！！！empId:" + empId);
        return SUCCESS;
    }
}
