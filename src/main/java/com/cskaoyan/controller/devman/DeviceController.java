package com.cskaoyan.controller.devman;


import com.cskaoyan.bean.devman.Device;
import com.cskaoyan.bean.devman.DeviceManager;
import com.cskaoyan.service.devman.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.PublicKey;
import java.util.List;

@Controller
public class DeviceController {
    @Autowired
    IDeviceService deviceService;
    @Autowired
    HttpSession session;
    @RequestMapping("device/deviceList")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        String[] sysPermissionList={"device:add","device:edit","device:delete"};
        session.setAttribute("sysPermissionList",sysPermissionList);
        modelAndView.setViewName("deviceList");
        return modelAndView;
    }

    @RequestMapping("deviceList/list")
    @ResponseBody
    public DeviceManager findDevAll(@RequestParam("page") int page, @RequestParam("rows") int rows){
        DeviceManager all = deviceService.findAll(page,rows);
        return all;
    }

    @ResponseBody
    @RequestMapping("deviceList/get_data")
    public List<Device> findData(){
        List<Device> list=deviceService.findAll();
        return list;
    }

    @RequestMapping("deviceList/search_device_by_deviceId")
    @ResponseBody
    public DeviceManager searchDeviceByDeviceId(@RequestParam("searchValue") String id,@RequestParam("page") int page, @RequestParam("rows") int rows){
        DeviceManager byId = deviceService.findById(id, page, rows);
        return byId;
    }

    @RequestMapping("/deviceList/add_judge")
    @ResponseBody
    public String judge(){
        return "";
    }

    @RequestMapping("deviceList/add")
    public ModelAndView add(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("deviceList_add");
        return mv;
    }

    @RequestMapping("deviceList/insert")
    public void insert(Device device){
        deviceService.insert(device);
    }
}