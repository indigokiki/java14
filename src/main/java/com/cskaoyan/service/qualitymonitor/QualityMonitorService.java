package com.cskaoyan.service.qualitymonitor;

import com.cskaoyan.bean.*;
import com.cskaoyan.bean.technology.Process;
import com.cskaoyan.bean.technology.TechnologyPlan;


import java.util.List;

public interface QualityMonitorService {

    List<Department> getDepartmentList();

    List<Custom> getCustomList();

    List<Product> getProductList();

    List<TechnologyPlan> getTechnologyPlanList();

    List<OrderByRevEngineering> getOrderList();

    List<Process> getProcessList();

    Page getMeasurePage(int page,int rows);

    Page getUnqualifyPage(int page,int rows);

    Page getFCountCheckPage(int page,int rows);

    Page getPMeasureCheckPage(int page,int rows);

    Page getPCountCheckPage(int page,int rows);

    int addUnqualifyApply(UnqualifyApply unqualifyApply);

    int addFinalMeasuretCheck(FinalMeasuretCheck finalMeasuretCheck);

    int addFinalCountCheck(FinalCountCheck finalCountCheck);

    int addProcessMeasureCheck(ProcessMeasureCheck processMeasureCheck);

    int addProcessCountCheck(ProcessCountCheck processCountCheck);

    int updateUnqualifyApply(UnqualifyApply unqualifyApply);

    int updateFinalMeasuretCheck(FinalMeasuretCheck finalMeasuretCheck);

    int updateFinalCountCheck(FinalCountCheck finalCountCheck);

    int updateProcessMeasureCheck(ProcessMeasureCheck processMeasureCheck);

    int updateProcessCountCheck(ProcessCountCheck processCountCheck);

    int deleteUnqualifyApply(String[] unqualifyApplyIds);

    int deleteFinalMeasuretCheck(String[] finalMeasuretCheckIds);

    int deleteFinalCountCheck(String[] finalCountCheckIds);

    int deleteProcessMeasureCheck(String[] processMeasureCheckIds);

    int deleteProcessCountCheck(String[] processCountCheckIds);

}
