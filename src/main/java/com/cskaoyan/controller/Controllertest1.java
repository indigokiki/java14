package com.cskaoyan.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controllertest1 {

    @RequestMapping("hello")
    public String test1(){
        return "/WEB-INF/jsp/login.jsp";
    }
}
