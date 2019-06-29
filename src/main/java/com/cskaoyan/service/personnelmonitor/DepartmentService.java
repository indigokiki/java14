package com.cskaoyan.service.personnelmonitor;

import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.Page;

import java.util.List;

public interface DepartmentService {
    List<Department> getDepartmentList();

    Page getDepartmentPage(int page, int rows);

   int addDepartment(Department department);

   int updataDepartment(Department department);

    int deleteDepartment(String[] departmentIds);

    Page selectDepratmentByDepartmentId(String searchValue,int page,int rows);

    Page selectDepratmentByDepartmentName(String searchValue,int page,int rows);
}
