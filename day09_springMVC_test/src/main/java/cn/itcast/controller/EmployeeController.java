package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/EmpController")
public class EmployeeController {

    private final static  String SUCCESS = "success";

    @RequestMapping(value = {"/saveEmp","/insertEmp"},
                    method = RequestMethod.GET,
                    params = "lastName",
                    headers = "User-Agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36"
    )
    public String saveEmp(){
        System.out.println("添加员工信息！！！！");
        return SUCCESS;
    }

    /**
     * 测试Ant风格URL
     * @return
     */
    @RequestMapping("/testAnt/?")
    /*?：匹配一个字符
    *：匹配任意字符
    **：匹配多层路径*/
    public String testAnt(){
        System.out.println("==>测试Ant成功！！！");
        return SUCCESS;
    }

    /**
     * 测试PathVariable
     * @return
     */
    @RequestMapping("/testPathVariable/{empId}")
    public String testPathVariable(@PathVariable(value = "empId") Integer empId){
        System.out.println("empId = " + empId);
        return SUCCESS;

    }
}
