package com.cskaoyan.controller;

import com.cskaoyan.bean.Order;
import com.cskaoyan.bean.Page;
import com.cskaoyan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("list")
    @ResponseBody
    public Page<Order> getOrderList(String page, String rows){

        Page<Order> orderPage = orderService.selectOrdersByPage(Integer.parseInt(page), Integer.parseInt(rows));
        return orderPage;
    }

    @RequestMapping("hello")
    public String home(){

        return "home";
    }
}
