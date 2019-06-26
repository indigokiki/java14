package com.cskaoyan.service;

import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.DepartmentExample;
import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.UnqualifyApply;
import com.cskaoyan.mapper.DepartmentMapper;
import com.cskaoyan.mapper.UnqualifyApplyMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QualityMonitorServiceImpl implements QualityMonitorService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    UnqualifyApplyMapper unqualifyApplyMapper;

    @Override
    public List<Department> getDepartmentList() {
        DepartmentExample departmentExample = new DepartmentExample();
        List<Department> departments = departmentMapper.selectByExample(departmentExample);
        return departments;
    }

    @Override
    public Page getUnqualifyPage(int page,int rows) {
        PageHelper.startPage(page,rows);
        List<UnqualifyApply> unqualifyApplies = unqualifyApplyMapper.getUnqualifyApplyList();

        Page<UnqualifyApply> returnpage = new Page<>();
        returnpage.setTotal(unqualifyApplies.size());
        returnpage.setRows(unqualifyApplies);
        return returnpage;
    }
}
