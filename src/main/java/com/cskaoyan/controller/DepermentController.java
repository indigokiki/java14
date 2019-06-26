package com.cskaoyan.controller;

import com.cskaoyan.bean.Department;
import com.cskaoyan.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DepermentController {

    @Autowired
    IDepartmentService departmentService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        System.out.println("controller层");
        List<Department> all = departmentService.findAll();
        System.out.println(all);
        mv.setViewName("login");
        return mv;
    }
}
