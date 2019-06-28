package com.cskaoyan.service.devman;


import com.cskaoyan.bean.devman.DeviceType;
import com.cskaoyan.bean.devman.DeviceTypeManage;



public interface IDeviceTpyeService {
    public DeviceTypeManage findAll(int page, int rows);

    void update(DeviceType deviceType);

    void insert(DeviceType deviceType);

    void delete(String[] ids);
}
