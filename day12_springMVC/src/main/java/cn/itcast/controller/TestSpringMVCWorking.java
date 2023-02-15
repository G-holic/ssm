package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestSpringMVCWorking {


    /**
     * 测试SpringMVC工作原理
     * @return
     */
    @RequestMapping("/testSpringMVCWorking")
    public String testSpringMVCWorking(){
        System.out.println("==>testSpringMVCWorking");
        int i = 1/0;
        return "success";
    }
}
