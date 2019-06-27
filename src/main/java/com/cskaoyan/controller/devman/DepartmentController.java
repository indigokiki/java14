package com.cskaoyan.controller.devman;

import com.cskaoyan.bean.devman.Department;
import com.cskaoyan.bean.devman.Device;
import com.cskaoyan.mapper.devman.IDepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    IDepartmentMapper departmentMapper;

    @ResponseBody
    @RequestMapping("department/get_data")
    public List<Department> findAll(){
        List<Department> all = departmentMapper.findAll();
        return all;
    }
}
