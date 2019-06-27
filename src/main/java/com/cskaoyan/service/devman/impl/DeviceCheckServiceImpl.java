package com.cskaoyan.service.devman.impl;

import com.cskaoyan.bean.devman.DeviceCheck;
import com.cskaoyan.bean.devman.DeviceCheckManager;
import com.cskaoyan.mapper.devman.IDeviceCheckMapper;
import com.cskaoyan.service.devman.IDeviceCheckService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceCheckServiceImpl implements IDeviceCheckService {

    @Autowired
    IDeviceCheckMapper iDeviceCheckMapper;
    @Override
    public DeviceCheckManager findAll(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<DeviceCheck> all = iDeviceCheckMapper.findAll();
        DeviceCheckManager deviceCheckManager = new DeviceCheckManager();
        deviceCheckManager.setTotal(all.size());
        deviceCheckManager.setRows(all);
        return deviceCheckManager;
    }
}
