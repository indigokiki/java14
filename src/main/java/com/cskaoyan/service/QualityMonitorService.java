package com.cskaoyan.service;

import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.Page;


import java.util.List;

public interface QualityMonitorService {

    List<Department> getDepartmentList();

    Page getUnqualifyPage(int page,int rows);
}
