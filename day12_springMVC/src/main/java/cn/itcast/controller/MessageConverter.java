package cn.itcast.controller;

import cn.itcast.pojo.Employee;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MessageConverter {

    private final static String SUCCESS = "success";

    /**
     * 测试@RequestBody获取请求体
     * @param reqBody
     * @return
     */
    @RequestMapping(value = "/testRequestBody",method = RequestMethod.POST)
    public String testRequestBody(@RequestBody String reqBody){
        System.out.println("reqBody = " + reqBody);
        return SUCCESS;
    }

    /**
     * 测试HttpEntity获取请求头及请求体
     * @param req
     * @return
     */
    @RequestMapping(value = "/testHttpEntity",method = RequestMethod.POST)
    public String HttpEntity(HttpEntity<String> req){
        // 获取请求头
        HttpHeaders headers = req.getHeaders();
        System.out.println("headers = " + headers);
        // 获取请求体
        String body = req.getBody();
        System.out.println("body = " + body);
        return SUCCESS;
    }

    /**
     * 测试responseBody
     * @return
     */
    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody(){
        System.out.println("testResponseBody!!!!");
        return "hello";
    }

    /**
     * 【@ResponseBody】处理JSON数据
     * @return
     */
//    @RequestMapping(value = "/testJson",method = RequestMethod.POST)// 制造一个错误把默认的get请求改成post
    @RequestMapping(value = "/testJson")// 制造一个错误把默认的get请求改成post
    @ResponseBody
    public Employee testJson(){
        System.out.println("===>处理Json");
//        int i = 1/0;
        String s = null;
        s.length();
        // 将Employee对象转换为json格式响应
        Employee employee = new Employee(1001, "zs", "zs@163.com", 1);
        // Gson gson = new Gson();
        // String jsonStr = gson.toJson(employee);
        // response.getWriter.write(jsonStr); // javaweb实现
        return employee;
    }



}
