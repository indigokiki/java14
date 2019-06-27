/*
package com.cskaoyan.controller.schemedprogress;

import com.cskaoyan.bean.schemedprogress.OrderMangger;
import com.cskaoyan.service.schemedprogress.OrderService;
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
    public OrderMangger getOrderList(String page, String rows){
        OrderMangger orderMangger = orderService.selectOrdersByPage();
        return orderMangger;
    }

    @RequestMapping("find")
    public ModelAndView getList(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/order_list.jsp");
        return modelAndView;
    }
}
*/
