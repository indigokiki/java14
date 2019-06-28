package com.cskaoyan.controller.devman;


import com.cskaoyan.bean.devman.Device;
import com.cskaoyan.bean.devman.DeviceManager;
import com.cskaoyan.bean.devman.ResponseVo;
import com.cskaoyan.service.devman.IDeviceService;
import org.apache.ibatis.annotations.Param;
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
        modelAndView.setViewName("/WEB-INF/jsp/deviceList.jsp");
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

    @RequestMapping("deviceList/edit_judge")
    @ResponseBody
    public String edit(){
        return "";
    }
    @RequestMapping("deviceList/delete_judge")
    @ResponseBody
    public String delete(){
        return "";
    }

    @RequestMapping("deviceList/add")
    public ModelAndView add(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/WEB-INF/jsp/deviceList_add.jsp");
        return mv;
    }

    @RequestMapping("deviceList/edit")
    public ModelAndView editDev(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/WEB-INF/jsp/deviceList_edit.jsp");
        return mv;
    }

    @RequestMapping("deviceList/insert")
    @ResponseBody
    public ResponseVo insert(Device device){
        System.out.println("insert`111111111111111111111111111111");
        deviceService.insert(device);
        ResponseVo responseVo = new ResponseVo();
        responseVo.setStatus(200);
        responseVo.setData("");
        responseVo.setMsg("OK");
        return  responseVo;
    }

    @RequestMapping("deviceList/update")
    @ResponseBody
    public ResponseVo update(Device device){
        deviceService.update(device);
        ResponseVo responseVo = new ResponseVo();
        responseVo.setStatus(200);
        responseVo.setData("");
        responseVo.setMsg("OK");
        return  responseVo;
    }
    @RequestMapping("deviceList/delete_batch")
    @ResponseBody
    public ResponseVo delete(@Param("ids") String[] ids){
        deviceService.delete(ids);
        ResponseVo responseVo = new ResponseVo();
        responseVo.setStatus(200);
        responseVo.setData("");
        responseVo.setMsg("OK");
        return  responseVo;
    }

    @ResponseBody
    @RequestMapping("deviceList/search_device_by_deviceName")
    public DeviceManager searchDeviceByName(@RequestParam("searchValue") String searchValue,@RequestParam("page") int page, @RequestParam("rows") int rows){
        DeviceManager manager= deviceService.searchDeviceByName(searchValue,page,rows);
        return manager;
    }

    @ResponseBody
    @RequestMapping("deviceList/search_device_by_deviceTypeName")
    public DeviceManager searchDeviceByType(@RequestParam("searchValue") String searchValue,@RequestParam("page") int page, @RequestParam("rows") int rows){
        DeviceManager manager= deviceService.searchDeviceByType(searchValue,page,rows);
        return manager;
    }
}
