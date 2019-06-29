package com.cskaoyan.service.personnelmonitor;
import com.cskaoyan.bean.Employee;
import com.cskaoyan.bean.Employee_p;
import com.cskaoyan.bean.Page;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployeeList();

    Page getEmployeePage(int page, int rows);

    int addEmployee(Employee employee);

    int updataEmployee(Employee employee);

    int deleteEmployee(String[] employeeIds);

    Page selectEmployeeByEmployeeId(String searchValue,int page,int rows);

    Page selectEmployeeByEmployeeName(String searchValue,int page,int rows);

    Page selectEmployeeByDepartmentName(String searchValue,int page,int rows);
}
