package com.cskaoyan.service.personnelmonitor;
import com.cskaoyan.bean.*;
import com.cskaoyan.mapper.EmployeeMapper;
import java.util.List;
import com.cskaoyan.mapper.EmployeeMapper_p;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    EmployeeMapper_p employeeMapper_p;

    @Override
    public List <Employee> getEmployeeList() {
        EmployeeExample employeeExample = new EmployeeExample();
        List<Employee> employee = employeeMapper.selectByExample(employeeExample);
        return employee;
    }

    @Override
    public Page getEmployeePage(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<Employee_p> employeeList = employeeMapper_p.getEmployee_pList();
        Page<Employee_p> returnpage = new Page<>();
        returnpage.setTotal((int) employeeMapper.countByExample(new EmployeeExample()));
        returnpage.setRows(employeeList);
        return returnpage;
    }
}
