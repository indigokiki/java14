package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Department;
import com.cskaoyan.mapper.DeparmenMapper;
import com.cskaoyan.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("service")
public class DepartmentServiceImpl implements IDepartmentService {
    @Autowired
    DeparmenMapper deparmenMapper;
    @Override
    public List<Department> findAll() {
        System.out.println("service层代码");
        return deparmenMapper.findAll();
    }
}
