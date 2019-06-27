package com.cskaoyan.controller.schemedprogress;

import com.cskaoyan.bean.schemedprogress.ManufactureMagger;
import com.cskaoyan.service.schemedprogress.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManufactureController {

    @Autowired
    ManufactureService manufactureService;

    @RequestMapping("manufacture/find")
    public ModelAndView find(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/manufacture_list.jsp");
        return modelAndView;
    }

    @RequestMapping("manufacture/list")
    @ResponseBody
    public ManufactureMagger getManufactureMaggerByPage(String page, String rows){
        ManufactureMagger manufactureByPage = manufactureService.getManufactureByPage(page, rows);
        return manufactureByPage;
    }
}
