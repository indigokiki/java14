package com.cskaoyan.service.devman;


import com.cskaoyan.bean.devman.Device;
import com.cskaoyan.bean.devman.DeviceManager;

import java.util.List;

public interface IDeviceService {
    DeviceManager findAll(int page, int rows);

    List<Device> findAll();

    DeviceManager findById(String id,int page, int rows);
    public void insert(Device device);
}
