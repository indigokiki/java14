package com.cskaoyan.controller.personnelmonitor;

import com.cskaoyan.bean.Employee;
import com.cskaoyan.service.personnelmonitor.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.cskaoyan.bean.Page;

//员工管理
@Controller
@ResponseBody
public class PersonnelMonitorController {
    @Autowired
    EmployeeService employeeService;
    @RequestMapping("employee/find")
    public ModelAndView employeefind(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/employee_list.jsp");
        return modelAndView;
    }
    @RequestMapping("employee/list")
    public Page employeepage(int page,int rows){
        return employeeService.getEmployeePage(page,rows);
    }
}
