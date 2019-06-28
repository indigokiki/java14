package com.cskaoyan.service.schemedprogress.impl;

import com.cskaoyan.bean.*;
import com.cskaoyan.bean.devman.DeviceType;
import com.cskaoyan.bean.schemedprogress.WorkMagger;
import com.cskaoyan.bean.schemedprogress.WorkRow;
import com.cskaoyan.mapper.DeviceMapper;
import com.cskaoyan.mapper.ProductMapper;
import com.cskaoyan.mapper.WorkMapper;
import com.cskaoyan.mapper.devman.IDeviceTpyeMapper;
import com.cskaoyan.service.schemedprogress.WorkService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    IDeviceTpyeMapper iDeviceTpyeMapper;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    DeviceMapper deviceMapper;

    @Autowired
    WorkMapper workMapper;
    @Override
    public List<DeviceType> getAllDeviceType() {
        List<DeviceType> all = iDeviceTpyeMapper.findAll();

        return all;
    }

    @Override
    public WorkMagger getWorkByPage(String page, String rows) {
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<WorkRow> allWorkByPage = workMapper.getAllWorkByPage();
        int countWork = workMapper.getCountWork();
        WorkMagger workMagger = new WorkMagger();
        workMagger.setTotal(countWork);
        workMagger.setRows(allWorkByPage);
        return workMagger;
    }

    @Override
    public int insert(Work work) {
        int insert = workMapper.insert(work);
        return insert;
    }

    @Override
    public int updata(Work work) {
        int update = workMapper.updateByPrimaryKey(work);
        return update;
    }

    @Override
    public int delete(String[] ids) {
        int status = 1;
        for (String id : ids) {
            int delete = workMapper.deleteByPrimaryKey(id);
            if(delete == 0){
                status = 0;
            }
        }
        return status;
    }


    @Override
    public WorkMagger searchById(String searchValue, String page, String rows) {
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<WorkRow> workRows = workMapper.search_work_by_workId(searchValue);
        int count = workMapper.count_search_work_by_workId(searchValue);
        WorkMagger workMagger = new WorkMagger();
        workMagger.setTotal(count);
        workMagger.setRows(workRows);
        return workMagger;
    }

    @Override
    public WorkMagger searchByProduct(String searchValue, String page, String rows) {
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<WorkRow> workRows = workMapper.search_work_by_workProduct(searchValue);
        int count = workMapper.count_search_work_by_workProduct(searchValue);
        WorkMagger workMagger = new WorkMagger();
        workMagger.setTotal(count);
        workMagger.setRows(workRows);
        return workMagger;
    }

    @Override
    public WorkMagger searchByDevice(String searchValue, String page, String rows) {
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<WorkRow> workRows = workMapper.search_work_by_workDevice(searchValue);
        int count = workMapper.count_search_work_by_workDevice(searchValue);
        WorkMagger workMagger = new WorkMagger();
        workMagger.setTotal(count);
        workMagger.setRows(workRows);
        return workMagger;
    }

    @Override
    public WorkMagger searchByProcess(String searchValue, String page, String rows) {
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<WorkRow> workRows = workMapper.search_work_by_workProcess(searchValue);
        int count = workMapper.count_search_work_by_workProcess(searchValue);
        WorkMagger workMagger = new WorkMagger();
        workMagger.setTotal(count);
        workMagger.setRows(workRows);
        return workMagger;
    }

    @Override
    public List<Work> getAllWorks() {
        WorkExample workExample = new WorkExample();
        List<Work> works = workMapper.selectByExample(workExample);
        return works;
    }
}
