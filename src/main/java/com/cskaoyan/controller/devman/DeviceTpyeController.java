package com.cskaoyan.controller.devman;

import com.cskaoyan.bean.devman.DeviceType;
import com.cskaoyan.bean.devman.DeviceTypeManage;
import com.cskaoyan.mapper.devman.IDeviceTpyeMapper;
import com.cskaoyan.service.devman.IDeviceTpyeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller

public class DeviceTpyeController {
    @Autowired
    IDeviceTpyeService deviceTpyeService;
    @Autowired
    IDeviceTpyeMapper deviceTpyeMapper;
    @Autowired
    HttpSession session;
    @RequestMapping("deviceType/list")
    @ResponseBody
    public DeviceTypeManage findDeviceList(@RequestParam("page") int page, @RequestParam("rows") int rows){
        DeviceTypeManage all = deviceTpyeService.findAll(page, rows);
        return all;
    }

    @RequestMapping("device/deviceType")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        String[] sysPermissionList={"device:add","device:edit","device:delete"};
        session.setAttribute("sysPermissionList",sysPermissionList);
        mv.setViewName("deviceType");

        return mv;
    }


    @RequestMapping("deviceType/get_data")
    public List<DeviceType> findlist(){
        List<DeviceType> all = deviceTpyeMapper.findAll();
        return all;
    }
}
