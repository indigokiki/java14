package com.cskaoyan.service.qualitymonitor;

import com.cskaoyan.bean.*;
import com.cskaoyan.bean.technology.Process;
import com.cskaoyan.bean.technology.ProcessExample;
import com.cskaoyan.bean.technology.TechnologyPlan;
import com.cskaoyan.bean.technology.TechnologyPlanExample;
import com.cskaoyan.mapper.*;
import com.cskaoyan.mapper.technology.ProcessMapper;
import com.cskaoyan.mapper.technology.TechnologyPlanMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualityMonitorServiceImpl implements QualityMonitorService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    UnqualifyApplyMapper unqualifyApplyMapper;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    TechnologyPlanMapper technologyPlanMapper;

    @Autowired
    CustomMapper customMapper;

    @Autowired
    FinalMeasuretCheckMapper finalMeasuretCheckMapper;

    @Autowired
    FinalCountCheckMapper finalCountCheckMapper;

    @Autowired
    ProcessMeasureCheckMapper processMeasureCheckMapper;

    @Autowired
    ProcessCountCheckMapper processCountCheckMapper;

    @Autowired
    ProcessMapper processMapper;

    @Autowired
    OrderMapperByRevEngineering orderMapperByRevEngineering;

    @Override
    public List<Department> getDepartmentList() {
        DepartmentExample departmentExample = new DepartmentExample();
        List<Department> departments = departmentMapper.selectByExample(departmentExample);
        return departments;
    }

    @Override
    public List<Custom> getCustomList() {
        List<Custom> customs = customMapper.selectByExample(new CustomExample());
        return customs;
    }

    @Override
    public List<Product> getProductList() {
        List<Product> products = productMapper.selectByExample(new ProductExample());
        return products;
    }

    @Override
    public List<TechnologyPlan> getTechnologyPlanList() {
        List<TechnologyPlan> technologyPlans = technologyPlanMapper.selectByExample(new TechnologyPlanExample());
        return technologyPlans;
    }

    @Override
    public List<OrderByRevEngineering> getOrderList() {
        List<OrderByRevEngineering> orderByRevEngineerings = orderMapperByRevEngineering.selectByExample(new OrderExample());
        return orderByRevEngineerings;
    }

    @Override
    public List<Process> getProcessList() {
        List<Process> processes = processMapper.selectByExample(new ProcessExample());
        return processes;
    }

    @Override
    public Page getMeasurePage(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<FinalMeasuretCheck> finalMeasuretChecks = finalMeasuretCheckMapper.getFinalMeasuretCheckList();
        Page<FinalMeasuretCheck> returnpage = new Page<>();
        returnpage.setTotal(finalMeasuretCheckMapper.getFinalMeasuretCheckNum());
        returnpage.setRows(finalMeasuretChecks);
        return returnpage;
    }

    @Override
    public Page getUnqualifyPage(int page,int rows) {
        PageHelper.startPage(page,rows);
        List<UnqualifyApply> unqualifyApplies = unqualifyApplyMapper.getUnqualifyApplyList();
        Page<UnqualifyApply> returnpage = new Page<>();
        returnpage.setTotal(unqualifyApplyMapper.getUnqualifyApplyNum());
        returnpage.setRows(unqualifyApplies);
        return returnpage;
    }

    @Override
    public Page getFCountCheckPage(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<FinalCountCheck> finalCountCheckList = finalCountCheckMapper.getFinalCountCheckList();
        Page<FinalCountCheck> returnpage = new Page<>();
        returnpage.setTotal(finalCountCheckMapper.getFinalCountCheckNum());
        returnpage.setRows(finalCountCheckList);
        return returnpage;
    }

    @Override
    public Page getPMeasureCheckPage(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<ProcessMeasureCheck> processMeasureCheckList = processMeasureCheckMapper.getProcessMeasureCheckList();
        Page<ProcessMeasureCheck> returnpage = new Page<>();
        returnpage.setTotal(processMeasureCheckMapper.getProcessMeasureCheckNum());
        returnpage.setRows(processMeasureCheckList);
        return returnpage;
    }

    @Override
    public Page getPCountCheckPage(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<ProcessCountCheck> processCountCheckList = processCountCheckMapper.getProcessCountCheckList();
        Page<ProcessCountCheck> returnpage = new Page<>();
        returnpage.setTotal(processCountCheckMapper.getProcessCountCheckNum());
        returnpage.setRows(processCountCheckList);
        return returnpage;
    }

    @Override
    public int addUnqualifyApply(UnqualifyApply unqualifyApply) {
        int insert = unqualifyApplyMapper.insert(unqualifyApply);
        return insert;
    }

    @Override
    public int addFinalMeasuretCheck(FinalMeasuretCheck finalMeasuretCheck) {
        int insert = finalMeasuretCheckMapper.insert(finalMeasuretCheck);
        return insert;
    }

    @Override
    public int addFinalCountCheck(FinalCountCheck finalCountCheck) {
        int insert = finalCountCheckMapper.insert(finalCountCheck);
        return insert;
    }

    @Override
    public int addProcessMeasureCheck(ProcessMeasureCheck processMeasureCheck) {
        int insert = processMeasureCheckMapper.insert(processMeasureCheck);
        return insert;
    }

    @Override
    public int addProcessCountCheck(ProcessCountCheck processCountCheck) {
        int insert = processCountCheckMapper.insert(processCountCheck);
        return insert;
    }

    @Override
    public int updateUnqualifyApply(UnqualifyApply unqualifyApply) {
        int i = unqualifyApplyMapper.updateByPrimaryKey(unqualifyApply);
        return i;
    }

    @Override
    public int updateFinalMeasuretCheck(FinalMeasuretCheck finalMeasuretCheck) {
        int i = finalMeasuretCheckMapper.updateByPrimaryKey(finalMeasuretCheck);
        return i;
    }

    @Override
    public int updateFinalCountCheck(FinalCountCheck finalCountCheck) {
        return finalCountCheckMapper.updateByPrimaryKey(finalCountCheck);
    }

    @Override
    public int updateProcessMeasureCheck(ProcessMeasureCheck processMeasureCheck) {
        return processMeasureCheckMapper.updateByPrimaryKey(processMeasureCheck);
    }

    @Override
    public int updateProcessCountCheck(ProcessCountCheck processCountCheck) {
        return processCountCheckMapper.updateByPrimaryKey(processCountCheck);
    }

    @Override
    public int deleteUnqualifyApply(String[] unqualifyApplyId) {
        for (String id : unqualifyApplyId) {
            int i = unqualifyApplyMapper.deleteByPrimaryKey(id);
            if(1 != i){
                //throw new Exception("error delete data");
                return 0;
            }
        }
        return 1;
    }

    @Override
    public int deleteFinalMeasuretCheck(String[] finalMeasuretCheckIds) {
        for (String id : finalMeasuretCheckIds) {
            int i = finalMeasuretCheckMapper.deleteByPrimaryKey(id);
            if(1 != i){
                //throw new Exception("error delete data");
                return 0;
            }
        }
        return 1;
    }

    @Override
    public int deleteFinalCountCheck(String[] finalCountCheckIds) {
        for (String id : finalCountCheckIds) {
            int i = finalCountCheckMapper.deleteByPrimaryKey(id);
            if(1 != i){
                //throw new Exception("error delete data");
                return 0;
            }
        }
        return 1;
    }

    @Override
    public int deleteProcessMeasureCheck(String[] processMeasureCheckIds) {
        for (String id : processMeasureCheckIds) {
            int i = processMeasureCheckMapper.deleteByPrimaryKey(id);
            if(1 != i){
                //throw new Exception("error delete data");
                return 0;
            }
        }
        return 1;
    }

    @Override
    public int deleteProcessCountCheck(String[] processCountCheckIds) {
        for (String id : processCountCheckIds) {
            int i = processCountCheckMapper.deleteByPrimaryKey(id);
            if(1 != i){
                //throw new Exception("error delete data");
                return 0;
            }
        }
        return 1;
    }

}
