package com.cskaoyan.controller.devman;

import com.cskaoyan.bean.devman.DeviceMaintainManager;
import com.cskaoyan.service.devman.IDeviceMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class DeviceMaintainController {
    @Autowired
    IDeviceMaintainService deviceMaintainService;
    @Autowired
    HttpSession session;
    @RequestMapping("device/deviceMaintain")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/WEB-INF/jsp/deviceMaintain.jsp");
        String[] sysPermissionList={"device:add","device:edit","device:delete"};
        session.setAttribute("sysPermissionList",sysPermissionList);
        return mv;
    }

    @RequestMapping("deviceMaintain/list")
    @ResponseBody
    public DeviceMaintainManager findDevAll(@RequestParam("page") int page, @RequestParam("rows") int rows){
        DeviceMaintainManager all = deviceMaintainService.findAll(page,rows);
        return all;
    }
}
