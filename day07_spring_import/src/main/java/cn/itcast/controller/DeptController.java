package cn.itcast.controller;

import cn.itcast.pojo.Dept;
import cn.itcast.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DeptController {

    @Autowired
    private DeptService deptService;
    void saveDept(){
        deptService.saveDept(new Dept());
    }
}
