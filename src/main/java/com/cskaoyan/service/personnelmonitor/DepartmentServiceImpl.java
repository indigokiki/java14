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

    @Override
    public int addDepartment(Department department) {
        int insert = departmentMapper.insert(department);
        return insert;
    }

    @Override
    public int updataDepartment(Department department) {
        int i = departmentMapper.updateByPrimaryKey(department);
        return i;
    }

    @Override
    public int deleteDepartment(String[] departmentIds) {
        for (String id : departmentIds) {
            int i = departmentMapper.deleteByPrimaryKey(id);
            if(1 != i){
                return 0;
            }
        }
        return 1;
    }

    @Override
    public Page selectDepratmentByDepartmentId(String searchValue, int page, int rows) {
        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria = departmentExample.createCriteria();
        criteria.andDepartmentIdLike("%" + searchValue + "%");
        PageHelper.startPage(page,rows);
        Page<Department> mypage = new Page<>();
        mypage.setRows(departmentMapper.selectByExample(departmentExample));
        mypage.setTotal((int)departmentMapper.countByExample(departmentExample));
        return mypage;
    }

    @Override
    public Page selectDepratmentByDepartmentName(String departmentname, int page, int rows) {
        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria = departmentExample.createCriteria();
        criteria.andDepartmentNameLike("%" + departmentname + "%");
        PageHelper.startPage(page, rows);
        Page<Department> mypage = new Page<>();
        mypage.setRows(departmentMapper.selectByExample(departmentExample));
        mypage.setTotal((int) departmentMapper.countByExample(departmentExample));
        return mypage;
    }
}
