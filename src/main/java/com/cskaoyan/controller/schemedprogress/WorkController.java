package com.cskaoyan.controller.schemedprogress;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.Work;
import com.cskaoyan.bean.devman.DeviceType;
import com.cskaoyan.bean.schemedprogress.WorkMagger;
import com.cskaoyan.service.schemedprogress.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class WorkController {

    @Autowired
    WorkService workService;

    @RequestMapping("work/find")
    public ModelAndView find(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/work_list.jsp");
        return modelAndView;
    }

    @RequestMapping("deviceType/get_data")
    @ResponseBody
    public List<DeviceType> getAllDeviceType(){
        List<DeviceType> allDeviceType = workService.getAllDeviceType();
        return allDeviceType;
    }

    @RequestMapping("work/list")
    @ResponseBody
    public WorkMagger getAllWork(String page, String rows){
        WorkMagger workByPage = workService.getWorkByPage(page, rows);
        return workByPage;
    }

}
