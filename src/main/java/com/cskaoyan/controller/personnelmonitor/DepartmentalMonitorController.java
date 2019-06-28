package com.cskaoyan.controller.personnelmonitor;

import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.Page;
import com.cskaoyan.service.personnelmonitor.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//部门管理
@Controller
@ResponseBody
public class DepartmentalMonitorController {
    @Autowired
    DepartmentService departmentService;
    @RequestMapping("department/find")
    public ModelAndView departermentfind(ModelAndView modelAndView) {
        modelAndView.setViewName("/WEB-INF/jsp/department_list.jsp");
        return modelAndView;
    }
    @RequestMapping("department/list")
    public Page employeepage(int page, int rows){
        return departmentService.getDepartmentPage(page,rows);
    }
}
