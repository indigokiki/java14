package com.cskaoyan.controller.material;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.material.*;
import com.cskaoyan.mapper.material.MaterialMapper;
import com.cskaoyan.service.material.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Controller
public class MaterialMonitorController {
    @Autowired
    MaterialService materialService;

    @Autowired
    HttpSession session;

    //物料信息
    @RequestMapping("/material/find")
    public ModelAndView findMaterial(){
        ModelAndView modelAndView = new ModelAndView();
        String[] sysPermissionList = {"material:add","material:edit","material:delete"};
        session.setAttribute("sysPermissionList",sysPermissionList);
        modelAndView.setViewName("/WEB-INF/jsp/material_list.jsp");
        return modelAndView;
    }
    @RequestMapping("/material/list")
    @ResponseBody
    public Page<Material> MaterialList(int page, int rows){

        Page<Material> materialPage = materialService.selectMaterialPage(page, rows);
        return materialPage;
    }
    //物料新增判断
    @RequestMapping("/material/add_judge")
    @ResponseBody
    public String addMaterialjudge(){
        return "{}";
    }
    //物料新增页面跳转
    @RequestMapping("/material/add")
    public ModelAndView addMaterial(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/jsp/material_add.jsp");
        return modelAndView;
    }
    //物料新增到数据库
    @RequestMapping("/material/insert")
    @ResponseBody
    public Map<String,Object> insertMaterial(Material material){
        int i = materialService.insertMaterial(material);
        Map<String, Object> map = new HashMap<>();
        if(i==1){
            map.put("status",200);
            map.put("msg","ok");
        }else{
            map.put("data","error");
        }
        return map;
    }
    //物料删除确认
    @RequestMapping("/material/delete_judge")
    @ResponseBody
    public String deleteMaterialConfirm(){
        return "{}";
    }
    //物料从数据库删除
    @RequestMapping("/material/delete_batch")
    @ResponseBody
    public Map<String,Object> deleteMaterials(String[] ids){
        int i = 0;
        for(String id : ids){
             i += materialService.deleteMaterials(id);
        }
        Map<String, Object> map = new HashMap<>();
        if(i>=1){
            map.put("status",200);
            map.put("msg","ok");
        }else{
            map.put("data","error");
        }
        return map;
    }

    //物料收入
    @RequestMapping("/materialReceive/find")
    public ModelAndView findMaterialReceive(){
        ModelAndView modelAndView = new ModelAndView();
        String[] sysPermissionList = {"materialReceive:add","materialReceive:edit","materialReceive:delete"};
        session.setAttribute("sysPermissionList",sysPermissionList);
        modelAndView.setViewName("/WEB-INF/jsp/materialReceive_list.jsp");
        return modelAndView;
    }
    @RequestMapping("/materialReceive/list")
    @ResponseBody
    public Page<MaterialReceives> MaterialReceives(int page, int rows){
        Page<MaterialReceives> materialReceivesPage = materialService.selectMaterialReceivesPage(page, rows);
        return materialReceivesPage;
    }
    //物料消耗
    @RequestMapping("/materialConsume/find")
    public ModelAndView findMaterialConsume(){
        ModelAndView modelAndView = new ModelAndView();
        String[] sysPermissionList = {"materialConsume:add","materialConsume:edit","materialConsume:delete"};
        session.setAttribute("sysPermissionList",sysPermissionList);
        modelAndView.setViewName("/WEB-INF/jsp/materialConsume_list.jsp");
        return modelAndView;
    }
    @RequestMapping("/materialConsume/list")
    @ResponseBody
    public Page<MaterialConsumes> MaterialConsumes(int page, int rows){
        Page<MaterialConsumes> materialConsumesPage = materialService.selectMaterialConsumesPage(page,rows);
        return materialConsumesPage;
    }
    @Autowired
    MaterialMapper materialMapper;
    @RequestMapping("/ilm")
    @ResponseBody
    public List<MaterialReceives> mytest(){
        List<MaterialReceives> materialReceives = materialMapper.allMaterialReceives();
        return materialReceives;
    }
}
