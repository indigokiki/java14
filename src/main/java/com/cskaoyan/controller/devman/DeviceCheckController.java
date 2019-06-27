package com.cskaoyan.controller.devman;

import com.cskaoyan.bean.devman.DeviceCheckManager;
import com.cskaoyan.service.devman.IDeviceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class DeviceCheckController {
    @Autowired
    IDeviceCheckService deviceCheckService;

    @Autowired
    HttpSession session;
    @RequestMapping("device/deviceCheck")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        String[] sysPermissionList={"device:add","device:edit","device:delete"};
        session.setAttribute("sysPermissionList",sysPermissionList);
        mv.setViewName("deviceCheck");
        return mv;
    }

    @RequestMapping("deviceCheck/list")
    @ResponseBody
    public DeviceCheckManager findDevAll(@RequestParam("page") int page, @RequestParam("rows") int rows){
        DeviceCheckManager all = deviceCheckService.findAll(page,rows);
        return all;
    }
}
