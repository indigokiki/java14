package com.cskaoyan.service.devman.impl;

import com.cskaoyan.bean.devman.DeviceMaintain;
import com.cskaoyan.bean.devman.DeviceMaintainManager;
import com.cskaoyan.mapper.devman.IDeviceMaintainMapper;
import com.cskaoyan.service.devman.IDeviceMaintainService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceMaintainServiceImpl implements IDeviceMaintainService {

    @Autowired
    IDeviceMaintainMapper iDeviceMaintainMapper;
    @Override
    public DeviceMaintainManager findAll(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<DeviceMaintain> all = iDeviceMaintainMapper.findAll();
        DeviceMaintainManager deviceMaintainManager = new DeviceMaintainManager();
        deviceMaintainManager.setTotal(all.size());
        deviceMaintainManager.setRows(all);
        return deviceMaintainManager;
    }
}
