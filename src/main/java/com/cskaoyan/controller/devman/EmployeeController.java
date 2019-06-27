package com.cskaoyan.controller.devman;

import com.cskaoyan.bean.devman.Employee;
import com.cskaoyan.mapper.devman.IEmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    IEmployeeMapper employeeMapper;
    @RequestMapping("employee/get_data")
    @ResponseBody
    public List<Employee> findAll(){
        List<Employee> all = employeeMapper.findAll();
        return all;
    }
}
