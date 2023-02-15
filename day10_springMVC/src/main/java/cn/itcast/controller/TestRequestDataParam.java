package cn.itcast.controller;

import cn.itcast.pojo.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TestRequestDataParam {

    private final static String SUCCESS = "success";


    /**
     * 获取请求参数
     *
     * @return
     */
    @RequestMapping("/requestParam1")
    public String requestParam1(@RequestParam("sName") String stuName, Integer stuAge) {
        System.out.println("stuName = " + stuName + ", stuAge = " + stuAge);
        return SUCCESS;
    }

    /**
     * 获取请求参数
     * @return
     */
    @RequestMapping(value = "/saveEmp",method = RequestMethod.POST)
    public String saveEmp(Employee employee){
        System.out.println("employee = " + employee);
        return SUCCESS;
    }

    /**
     * 测试 testGetHeader
     * @param al
     * @param ref
     * @return
     */
    @RequestMapping("/testGetHeader")
    public String testGetHeader(@RequestHeader(value = "Accept-Language") String al,
                                @RequestHeader(value = "Referer") String ref){
        System.out.println("al = " + al);
        System.out.println("ref = " + ref);
        return SUCCESS;
    }

    /**
     * 设置Cookie信息
     * @return
     */
    @RequestMapping("/setCookie")
    public String setCookie(HttpSession session){
//        Cookie cookie = new Cookie(); // 暂时不用
        System.out.println("session.getId() = " + session.getId());
        return SUCCESS;
    }

    /**
     * 获取Cookie信息
     * @return
     */
    @RequestMapping("/getCookie")
    public String  getCookie(@CookieValue("JSESSIONID") String cookeValue){
        System.out.println("cookeValue = " + cookeValue);
        return SUCCESS;
    }


    /**
     * 使用原生Servlet-API
     * @param request
     * @return
     */
    @RequestMapping("/userRequestObject")
    public String userRequestObject(HttpServletRequest request){
        // 获取Servlet上下文对象
        ServletContext servletContext = request.getServletContext();
        // 获取某个文件的真实路径
        String realPath = servletContext.getRealPath("/WEB-INF/pages/index.html");
        System.out.println("realPath = " + realPath);
        return SUCCESS;
    }
}
