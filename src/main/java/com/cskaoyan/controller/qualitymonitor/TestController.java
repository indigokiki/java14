package com.cskaoyan.controller.qualitymonitor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("homepage")
    public String home(){
        return "WEB-INF/jsp/home.jsp";
    }
}
