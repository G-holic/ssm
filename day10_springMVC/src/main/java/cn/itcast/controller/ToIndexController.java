package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToIndexController {

//    @RequestMapping("/")
    public String toIndex() {
        return "index";
    }

//    @RequestMapping("/toRestPage")
    public String toRestPage() {
        return "rest_page";
    }

    /**
     * 跳转到toRequestDataPage
     *
     * @return
     */

//    @RequestMapping("/toRequestDataPage")
    public String toRequestDataPage() {
        return "toRequestDataPage";

    }

    /**
     * 跳转到toResponseDataPage
     * @return
     */
//    @RequestMapping("/toResponseDataPage")
    public String toResponseDataPage(){

        return "doResponseDataPage";
    }


}
