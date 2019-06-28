package com.cskaoyan.service.devman.impl;

import com.cskaoyan.bean.devman.Device;
import com.cskaoyan.bean.devman.DeviceManager;
import com.cskaoyan.mapper.devman.IDeviceMapper;
import com.cskaoyan.mapper.devman.IDeviceTpyeMapper;
import com.cskaoyan.service.devman.IDeviceService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceServiceImpl implements IDeviceService {

    @Autowired
    IDeviceMapper deviceMapper;

    @Autowired
    IDeviceTpyeMapper deviceTpyeMapper;
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

    @Override
    public void update(Device device) {
        deviceMapper.update(device);
    }

    @Override
    public void delete(String[] ids) {
        for (String id : ids) {
            deviceMapper.delete(id);
        }
    }

    @Override
    public DeviceManager searchDeviceByName(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);
        List<Device> list=deviceMapper.searchDeviceByName("%"+searchValue+"%");
        DeviceManager manager = new DeviceManager();
        manager.setTotal(list.size());
        manager.setRows(list);
        return manager;
    }
    @Override
    public DeviceManager searchDeviceByType(String searchValue, int page, int rows) {
  /*      PageHelper.startPage(page,rows);
        List<String> ids = deviceTpyeMapper.findIdByName("%" + searchValue + "%");

        List<Device> list=new ArrayList<>();
        for (String id : ids) {
            Device byTyeId = deviceMapper.findByTyeId(id);
            list.add(byTyeId);
        }*/
        PageHelper.startPage(page,rows);
        List<Device> list = deviceMapper.findByTyeId("%" + searchValue + "%");
        DeviceManager manager = new DeviceManager();
        manager.setTotal(list.size());
        manager.setRows(list);
        return manager;
    }
}
