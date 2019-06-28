package com.cskaoyan.controller.devman;

import com.cskaoyan.bean.devman.DeviceFault;
import com.cskaoyan.bean.devman.DeviceFaultManager;
import com.cskaoyan.bean.devman.DeviceManager;
import com.cskaoyan.service.devman.IDeviceFaultService;
import com.cskaoyan.service.devman.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class DeviceFaultController {
    @Autowired
    IDeviceFaultService deviceService;

    @Autowired
    HttpSession session;
    @RequestMapping("device/deviceFault")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        String[] sysPermissionList={"device:add","device:edit","device:delete"};
        session.setAttribute("sysPermissionList",sysPermissionList);
        modelAndView.setViewName("/WEB-INF/jsp/deviceFault.jsp");
        return modelAndView;
    }

    @RequestMapping("deviceFault/list")
    @ResponseBody
    public DeviceFaultManager findDevAll(@RequestParam("page") int page, @RequestParam("rows") int rows){
        DeviceFaultManager all = deviceService.findAll(page,rows);
        return all;
    }
}
