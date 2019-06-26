package com.erp.controller;

import com.erp.bean.User;
import com.erp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @Autowired
    UserService userService;

    @RequestMapping("user")
    @ResponseBody
    public User getUser(int id){
        User user = userService.getUserById(id);
        return user;
    }
}
