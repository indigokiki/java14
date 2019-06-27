package com.cskaoyan.service.schemedprogress;

import com.cskaoyan.bean.devman.DeviceType;
import com.cskaoyan.bean.schemedprogress.WorkMagger;

import java.util.List;

public interface WorkService {

    List<DeviceType> getAllDeviceType();

    WorkMagger getWorkByPage(String page, String rows);
}
