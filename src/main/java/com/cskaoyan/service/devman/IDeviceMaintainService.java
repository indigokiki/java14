package com.cskaoyan.service.devman;

import com.cskaoyan.bean.devman.DeviceCheckManager;
import com.cskaoyan.bean.devman.DeviceMaintain;
import com.cskaoyan.bean.devman.DeviceMaintainManager;

public interface IDeviceMaintainService {
    DeviceMaintainManager findAll(int page, int rows);
}
