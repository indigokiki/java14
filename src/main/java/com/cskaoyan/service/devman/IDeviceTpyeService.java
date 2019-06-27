package com.cskaoyan.service.devman;


import com.cskaoyan.bean.devman.DeviceTypeManage;



public interface IDeviceTpyeService {
    public DeviceTypeManage findAll(int page, int rows);
}
