package com.cskaoyan.service.devman.impl;

import com.cskaoyan.bean.devman.DeviceType;
import com.cskaoyan.bean.devman.DeviceTypeManage;
import com.cskaoyan.mapper.devman.IDeviceTpyeMapper;
import com.cskaoyan.service.devman.IDeviceTpyeService;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceTypeServiceImpl implements IDeviceTpyeService {
    @Autowired
    IDeviceTpyeMapper idevmanMapper;
    @Override
    public DeviceTypeManage findAll(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<DeviceType> all = idevmanMapper.findAll();
        DeviceTypeManage deviceTypeManage = new DeviceTypeManage();
        deviceTypeManage.setRows(all);
        deviceTypeManage.setTotal(all.size());
        return deviceTypeManage;
    }
}
