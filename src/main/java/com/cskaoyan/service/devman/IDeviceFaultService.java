package com.cskaoyan.service.devman;

import com.cskaoyan.bean.devman.DeviceFaultManager;

public interface IDeviceFaultService {
    DeviceFaultManager findAll(int page, int rows);
}
