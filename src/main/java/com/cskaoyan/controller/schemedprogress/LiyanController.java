package com.cskaoyan.controller.schemedprogress;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LiyanController {

    @RequestMapping("hello")
    public String home(){
        return "/WEB-INF/jsp/home.jsp";
    }
}
