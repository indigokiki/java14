package com.cskaoyan.controller.schemedprogress;

import com.cskaoyan.bean.schemedprogress.OrderMangger;
import com.cskaoyan.service.schemedprogress.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    HttpSession session;


    @RequestMapping("list")
    @ResponseBody
    public OrderMangger getOrderList(String page, String rows){
        OrderMangger orderMangger = orderService.selectOrdersByPage(page,rows);
        return orderMangger;
    }

    @RequestMapping("find")
    public ModelAndView getList(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/order_list.jsp");

        String[] sysPermissionList = {"order:add","order:edit","order:delete"};
        session.setAttribute("sysPermissionList",sysPermissionList);
        return modelAndView;
    }

    @RequestMapping("search_order_by_orderId")
    @ResponseBody
    public OrderMangger getOrderById(String searchValue, String page, String rows){
        OrderMangger orderMangger = orderService.selectOrderById(searchValue, page, rows);
        return orderMangger;
    }

    @RequestMapping("search_order_by_orderCustom")
    @ResponseBody
    public OrderMangger getOrderByCustom(String searchValue, String page, String rows){
        OrderMangger orderMangger = orderService.selectOrderByCustom(searchValue, page, rows);
        return orderMangger;
    }

    @RequestMapping("search_order_by_orderProduct")
    @ResponseBody
    public OrderMangger getOrderByProduct(String searchValue, String page, String rows){
        OrderMangger orderMangger = orderService.selectOrderByProduct(searchValue, page, rows);
        return orderMangger;
    }

    @RequestMapping("insert")
    @ResponseBody
    public Map insertOrder(String orderId, String customId, String productId,
                           String quantity, String unitPrice, String unit, String status,
                           Date orderDate, Date requestDate, MultipartFile image, MultipartFile orderAddFile, String note) throws IOException {
        File directory = new File("D://fileupload/image");
        if (!directory.exists()){
            directory.mkdir();
        }
        String name = image.getOriginalFilename();
        File file = new File(directory, name);
        image.transferTo(file);
        Map<String, Object> map = new HashMap();
        map.put("status", 200);
        map.put("msg","OK");
        map.put("data",null);
        return map;
    }


    @RequestMapping("add_judge")
    @ResponseBody
    public String add(){
        return "";
    }
    @RequestMapping("add")
    public ModelAndView add(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/order_add.jsp");
        return modelAndView;
    }
}
