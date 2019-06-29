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

    @Override
    public int addEmployee(Employee employee) {
        int insert = employeeMapper.insert(employee);
        return insert;
    }

    @Override
    public int updataEmployee(Employee employee) {
        int i = employeeMapper.updateByPrimaryKey(employee);
        return i;
    }

    @Override
    public int deleteEmployee(String[] employeeIds) {
        for (String id : employeeIds) {
            int i = employeeMapper.deleteByPrimaryKey(id);
            if(1 != i){
                return 0;
            }
        }
        return 1;
    }

    public Page selectEmployeeByEmployeeId(String id,int page,int rows){
        PageHelper.startPage(page, rows);
        List<Employee_p> employee_ps = employeeMapper_p.getByID(id);
        int count = employeeMapper_p.countgetByID(id);
        Page<Employee_p> page1 = new Page<>();
        page1.setTotal(count);
        page1.setRows(employee_ps);
        return page1;

    }

    @Override
    public Page selectEmployeeByEmployeeName(String employeename, int page, int rows) {
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andEmpNameLike("%" + employeename + "%");
        PageHelper.startPage(page,rows);
        Page<Employee> mypage = new Page<>();
        mypage.setRows(employeeMapper.selectByExample(employeeExample));
        mypage.setTotal((int)employeeMapper.countByExample(employeeExample));
        return mypage;
    }

    @Override
    public Page selectEmployeeByDepartmentName(String departmentname, int page, int rows) {
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andDepartmentIdLike("%" + departmentname + "%");
        PageHelper.startPage(page,rows);
        Page<Employee> mypage = new Page<>();
        mypage.setRows(employeeMapper.selectByExample(employeeExample));
        mypage.setTotal((int)employeeMapper.countByExample(employeeExample));
        return mypage;
    }
}
