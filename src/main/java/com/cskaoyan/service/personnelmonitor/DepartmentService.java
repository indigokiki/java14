package com.cskaoyan.service.personnelmonitor;

import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.Page;

import java.util.List;

public interface DepartmentService {
    List<Department> getDepartmentList();
    Page getDepartmentPage(int page, int rows);
}
