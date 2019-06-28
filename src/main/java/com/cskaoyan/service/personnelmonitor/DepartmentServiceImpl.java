package com.cskaoyan.service.personnelmonitor;

import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.DepartmentExample;
import com.cskaoyan.bean.Page;
import com.cskaoyan.mapper.DepartmentMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;


    @Override
    public List<Department> getDepartmentList() {
        DepartmentExample departmentExample  = new DepartmentExample();
        List<Department> departments = departmentMapper.selectByExample(departmentExample);
        return departments;
    }

    @Override
    public Page getDepartmentPage(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<Department> departmentList = departmentMapper.selectByExample(new DepartmentExample());
        Page<Department> returnpage = new Page<>();
        returnpage.setTotal((int)departmentMapper.countByExample(new DepartmentExample()));
        returnpage.setRows(departmentList);
        return returnpage;
    }
}
