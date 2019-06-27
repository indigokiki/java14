package com.cskaoyan.controller.schemedprogress;

import com.cskaoyan.bean.schemedprogress.OrderMangger;
import com.cskaoyan.bean.schemedprogress.ProductMagger;
import com.cskaoyan.service.schemedprogress.OrderService;
import com.cskaoyan.service.schemedprogress.ProductMaggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("product")
public class ProductMaggerController {

    @Autowired
    ProductMaggerService productMaggerService;

    @RequestMapping("list")
    @ResponseBody
    public ProductMagger getOrderList(String page, String rows){
        ProductMagger productMagger = productMaggerService.selectProducrsByPage(page, rows);
        return productMagger;
    }

    @RequestMapping("find")
    public ModelAndView getList(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/product_list.jsp");
        return modelAndView;
    }
}
