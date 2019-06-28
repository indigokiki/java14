package com.cskaoyan.service.personnelmonitor;
import com.cskaoyan.bean.Employee;
import com.cskaoyan.bean.Page;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployeeList();
    Page getEmployeePage(int page, int rows);
}
