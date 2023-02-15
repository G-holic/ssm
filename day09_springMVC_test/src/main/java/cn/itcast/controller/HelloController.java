package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    /**
     * 配置url【/】，映射到WEB-INF/pages/index.html
     * @return
     */
//    SpringResourceTemplateResolver
    @RequestMapping("/")
    public String toIndex(){
        //             /WEB-INF/pages/ index .html
        // 物理视图名 = 视图前缀 + 逻辑视图名 + 视图后缀
        return "index";
    }


    @RequestMapping("/HelloControllerMethod")
    public String helloWorld(){
        System.out.println("==>HelloController-->hellWorld()!!!");
        return "success";
    }

    @RequestMapping("/toEmpListPage")
    public String toEmpListPage(){

        return "empList";
    }
}
