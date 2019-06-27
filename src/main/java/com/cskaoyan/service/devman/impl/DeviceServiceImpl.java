package com.cskaoyan.service.devman.impl;

import com.cskaoyan.bean.devman.Device;
import com.cskaoyan.bean.devman.DeviceManager;
import com.cskaoyan.mapper.devman.IDeviceMapper;
import com.cskaoyan.service.devman.IDeviceService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements IDeviceService {

    @Autowired
    IDeviceMapper deviceMapper;
    @Override
    public DeviceManager findAll(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<Device> all = deviceMapper.findAll();
        DeviceManager deviceManager = new DeviceManager();
        deviceManager.setRows(all);
        deviceManager.setTotal(all.size());
        return deviceManager;
    }

    @Override
    public List<Device> findAll() {
        return deviceMapper.findAll();
    }

    @Override
    public DeviceManager findById(String id,int page, int rows) {
        PageHelper.startPage(page,rows);
        List<Device> byId = deviceMapper.findById("%" + id + "%");
        DeviceManager deviceManager = new DeviceManager();
        deviceManager.setRows(byId);
        deviceManager.setTotal(byId.size());
        return deviceManager;
    }

    @Override
    public void insert(Device device) {
        deviceMapper.insert(device);
    }
}
