package com.cskaoyan.service.schemedprogress;

import com.cskaoyan.bean.Work;
import com.cskaoyan.bean.devman.DeviceType;
import com.cskaoyan.bean.schemedprogress.WorkMagger;

import java.util.List;

public interface WorkService {

    List<DeviceType> getAllDeviceType();

    WorkMagger getWorkByPage(String page, String rows);

    int insert(Work work);

    int updata(Work work);

    int delete(String[] ids);

    WorkMagger searchById(String searchValue, String page, String rows);

    WorkMagger searchByProduct(String searchValue, String page, String rows);

    WorkMagger searchByDevice(String searchValue, String page, String rows);

    WorkMagger searchByProcess(String searchValue, String page, String rows);

    List<Work> getAllWorks();
}
