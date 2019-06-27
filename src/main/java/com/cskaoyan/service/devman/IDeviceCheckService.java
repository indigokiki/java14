package com.cskaoyan.service.devman;

import com.cskaoyan.bean.devman.DeviceCheckManager;

public interface IDeviceCheckService {
    DeviceCheckManager findAll(int page, int rows);
}
