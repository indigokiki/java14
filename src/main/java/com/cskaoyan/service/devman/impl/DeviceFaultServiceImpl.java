package com.cskaoyan.service.devman.impl;

import com.cskaoyan.bean.devman.DeviceFault;
import com.cskaoyan.bean.devman.DeviceFaultManager;
import com.cskaoyan.mapper.devman.IDeviceFaultMapper;
import com.cskaoyan.service.devman.IDeviceFaultService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceFaultServiceImpl implements IDeviceFaultService {

    @Autowired
    IDeviceFaultMapper deviceMapper;
    @Override
    public DeviceFaultManager findAll(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<DeviceFault> all = deviceMapper.findAll();
        DeviceFaultManager deviceManager = new DeviceFaultManager();
        deviceManager.setRows(all);
        deviceManager.setTotal(all.size());
        return deviceManager;
    }
}
