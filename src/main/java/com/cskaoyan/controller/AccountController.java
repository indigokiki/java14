package com.cskaoyan.controller;

import com.cskaoyan.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {
    @Autowired
    IAccountService accountService;

    @RequestMapping ("/trans")
    public String trans(){

        accountService.transcation(1,2);
        return "login";
    }
}
