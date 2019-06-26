package com.cskaoyan.controller;

import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.Page;
import com.cskaoyan.service.QualityMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@ResponseBody
public class QualityMonitorController {

    @Autowired
    QualityMonitorService qualityMonitorService;

    @RequestMapping("department/get_data")
    public List<Department> depgetdata(){
        return qualityMonitorService.getDepartmentList();
    }

    @RequestMapping("unqualify/find*")
    public ModelAndView unqualifyfind(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/unqualify_list.jsp");
        return modelAndView;
    }

    @RequestMapping("unqualify/list*")
    public Page unqualifypage(int page,int rows){
        return qualityMonitorService.getUnqualifyPage(page,rows);
    }
}
