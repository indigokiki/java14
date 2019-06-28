package com.cskaoyan.controller.schemedprogress;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("hello")
    public String home(){
        System.out.println("123");
        return "/WEB-INF/jsp/home.jsp";
    }
}
