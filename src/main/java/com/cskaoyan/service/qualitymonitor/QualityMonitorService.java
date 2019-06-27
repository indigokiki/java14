package com.cskaoyan.service.qualitymonitor;

import com.cskaoyan.bean.*;


import java.util.List;

public interface QualityMonitorService {

    List<Department> getDepartmentList();

    List<Custom> getCustomList();

    List<Product> getProductList();

    List<TechnologyPlan> getTechnologyPlanList();

    Page getMeasurePage(int page,int rows);

    Page getUnqualifyPage(int page,int rows);

    Page getFCountCheckPage(int page,int rows);

    Page getPMeasureCheckPage(int page,int rows);

    Page getPCountCheckPage(int page,int rows);

}
