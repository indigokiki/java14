package com.cskaoyan.service.schemedprogress.impl;

import com.cskaoyan.bean.Work;
import com.cskaoyan.bean.WorkExample;
import com.cskaoyan.bean.devman.DeviceType;
import com.cskaoyan.bean.schemedprogress.WorkMagger;
import com.cskaoyan.bean.schemedprogress.WorkRow;
import com.cskaoyan.mapper.WorkMapper;
import com.cskaoyan.mapper.devman.IDeviceTpyeMapper;
import com.cskaoyan.service.schemedprogress.WorkService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    IDeviceTpyeMapper iDeviceTpyeMapper;

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
}
