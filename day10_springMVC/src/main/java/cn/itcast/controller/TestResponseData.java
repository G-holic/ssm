package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/ResponseDataController")
@SessionAttributes(value = "stuName") //将request域中数据，同步到session域中
public class TestResponseData {
    private final static String SUCCESS = "response_success";

    @RequestMapping("/testMvResponseData")
    public ModelAndView testMvResponseData(){

        ModelAndView mv = new ModelAndView();
        // 设置数据【将数据共享到域中】
        mv.addObject("stuName","lilong");
        // 设置视图【转发或重定向】
        mv.setViewName(SUCCESS);
        return mv;
    }

    @RequestMapping("testModelOrModelMapOrMap")
    public String testModelOrModelMapOrMap(Model model/*Map<String,Object> map*/){
        // 设置数据
//        map.put("stuName","lisi");
        model.addAttribute("stuName","wangwu");
        return SUCCESS;
    }

    @GetMapping("/testSession")
    public String testSession(HttpSession session){
        // 设置数据【session域】
        session.setAttribute("stuName","zhaoliu");
        return SUCCESS;
    }

    /**
     * session2
     * @return
     */
    @GetMapping("/testSession2")
    public ModelAndView testSession2(){
        ModelAndView mv = new ModelAndView();
        //设置逻辑视图名
        mv.setViewName(SUCCESS);
        //设置数据【将数据共享到域中（request\session\servletContext）】
        mv.addObject("stuName","zhouxu");
        return mv;
    }

    /**
     * 测试重定向
     * @return
     */
    @GetMapping("/testRedirect")
    public String testRedirect(){
        System.out.println("==》测试重定向成功");
        return "redirect:/redirect_success.html";
    }
}
