package com.cskaoyan.controller.schemedprogress;

import com.cskaoyan.bean.OrderByRevEngineering;
import com.cskaoyan.bean.schemedprogress.Order;
import com.cskaoyan.bean.schemedprogress.OrderMangger;
import com.cskaoyan.service.schemedprogress.OrderService;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseVo insertOrder(OrderByRevEngineering order) throws IOException {
        int status = orderService.insert(order);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (status == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("操作失败！请联系管理员！");
        }
        return responseVo;
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

    @RequestMapping("delete_judge")
    @ResponseBody
    public String delete(){
        return "";
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public ResponseVo delete(String[] ids){

        int i = orderService.deleteByIds(ids);
        int status = 0;
        if(i > 0){
            status = 1;
        }
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (status == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("操作失败！请联系管理员！");
        }
        return responseVo;
    }

    @RequestMapping("edit_judge")
    @ResponseBody
    public String edit_judge(){
        return "{}";
    }

    @RequestMapping("edit")
    public ModelAndView edit(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/order_edit.jsp");
        return modelAndView;
    }

    @RequestMapping("update_all")
    @ResponseBody
    public ResponseVo update_all(OrderByRevEngineering order){
        int status = orderService.update(order);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (status == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("操作失败！请联系管理员！");
        }
        return responseVo;
    }

    @RequestMapping("get/{oid}")
    @ResponseBody
    public OrderByRevEngineering get(@PathVariable("oid") String oid){
        OrderByRevEngineering order = orderService.getById(oid);
        return order;
    }

}
