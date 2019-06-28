package com.cskaoyan.controller.devman;

import com.cskaoyan.bean.devman.Device;
import com.cskaoyan.bean.devman.DeviceType;
import com.cskaoyan.bean.devman.DeviceTypeManage;
import com.cskaoyan.bean.devman.ResponseVo;
import com.cskaoyan.mapper.devman.IDeviceTpyeMapper;
import com.cskaoyan.service.devman.IDeviceTpyeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
        String[] sysPermissionList={"deviceType:add","deviceType:edit","deviceType:delete"};
        session.setAttribute("sysPermissionList",sysPermissionList);
        mv.setViewName("/WEB-INF/jsp/deviceType.jsp");

        return mv;
    }



    @RequestMapping("deviceType/get_data")
    @ResponseBody
    public List<DeviceType> findlist(){
        List<DeviceType> all = deviceTpyeMapper.findAll();
        return all;
    }


    @RequestMapping("deviceType/get/{id}")
    @ResponseBody
    public DeviceType findByTypeId(@PathVariable("id") String id){
        DeviceType byTypeId = deviceTpyeMapper.findByTypeId(id);
        return byTypeId;
    }

    @RequestMapping("deviceType/edit_judge")
    @ResponseBody
    public String judge(){
        return "";
    }

    @RequestMapping("deviceType/update_all")
    @ResponseBody
    public ResponseVo updateAll(DeviceType deviceType){
        deviceTpyeService.update(deviceType);
        ResponseVo responseVo = new ResponseVo();
        responseVo.setStatus(200);
        responseVo.setData("");
        responseVo.setMsg("OK");
        return  responseVo;
    }



    @RequestMapping("/deviceType/add_judge")
    @ResponseBody
    public String add_judge(){
        return "";
    }

    @RequestMapping("deviceType/delete_judge")
    @ResponseBody
    public String delete(){
        return "";
    }

    @RequestMapping("deviceType/add")
    public ModelAndView add(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/WEB-INF/jsp/deviceType_add.jsp");
        return mv;
    }

    @RequestMapping("deviceType/insert")
    @ResponseBody
    public ResponseVo insert(DeviceType deviceType){
        deviceTpyeService.insert(deviceType);
        ResponseVo responseVo = new ResponseVo();
        responseVo.setStatus(200);
        responseVo.setData("");
        responseVo.setMsg("OK");
        return  responseVo;
    }

    @RequestMapping("deviceType/edit")
    public ModelAndView editDev(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/WEB-INF/jsp/deviceType_edit.jsp");
        return mv;
    }

    @RequestMapping("deviceType/update")
    @ResponseBody
    public ResponseVo update(DeviceType deviceTpye){
        deviceTpyeService.update(deviceTpye);
        ResponseVo responseVo = new ResponseVo();
        responseVo.setStatus(200);
        responseVo.setData("");
        responseVo.setMsg("OK");
        return  responseVo;
    }

    @RequestMapping("deviceType/delete_batch")
    @ResponseBody
    public ResponseVo delete(@Param("ids") String[] ids){
        deviceTpyeService.delete(ids);
        ResponseVo responseVo = new ResponseVo();
        responseVo.setStatus(200);
        responseVo.setData("");
        responseVo.setMsg("OK");
        return  responseVo;
    }

}
