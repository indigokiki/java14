package com.cskaoyan.controller.schemedprogress;

import com.cskaoyan.bean.Custom;
import com.cskaoyan.bean.schemedprogress.CustomMagger;
import com.cskaoyan.service.schemedprogress.CustomMaggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("custom")
public class CustomMaggerController {

    @Autowired
    CustomMaggerService customMaggerService;

    @RequestMapping("list")
    @ResponseBody
    public CustomMagger getCustomList(String page, String rows){
        CustomMagger customMagger = customMaggerService.selectOrdersByPage(page, rows);
        return customMagger;
    }

    @RequestMapping("find")
    public ModelAndView getList(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/custom_list.jsp");
        return modelAndView;
    }

    @RequestMapping("get/{cid}")
    @ResponseBody
    public Custom getCustomById(@PathVariable("cid") String cid){
        List<Custom> customs = customMaggerService.selectOrdersById(cid);
        Custom custom = customs.get(0);

        return custom;
    }
}
