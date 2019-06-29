package com.cskaoyan.controller.material;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.material.Material;
import com.cskaoyan.bean.material.MaterialReceive;
import com.cskaoyan.bean.material.MaterialReceives;
import com.cskaoyan.service.material.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author IL-M
 * @Date:2019/6/28 10:49
 */
@Controller
public class MaterialReceiveController {
    @Autowired
    MaterialService materialService;

    @Autowired
    HttpSession session;

    //物料收入数据展示
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

    //物料收入新增判断
    @RequestMapping("/materialReceive/add_judge")
    @ResponseBody
    public String addMaterialReceivejudge(){
        return "{}";
    }
   //物料收入新增页面跳转
    @RequestMapping("/materialReceive/add")
    public ModelAndView addMaterialReceive(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/jsp/materialReceive_add.jsp");
        return modelAndView;
    }
    //物料收入新增到数据库
    @RequestMapping("/materialReceive/insert")
    @ResponseBody
    public Map<String,Object> insertMaterialReceive(MaterialReceive materialReceive){
        int i = materialService.insertMaterialReceive(materialReceive);
        Map<String, Object> map = new HashMap<>();
        if(i==1){
            map.put("status",200);
            map.put("msg","ok");
        }else{
            map.put("data","error");
        }
        return map;
    }
    //物料收入編輯判斷
    @RequestMapping("/materialReceive/edit_judge")
    @ResponseBody
    public String editMaterialReceivejudge(){
        return "{}";
    }
    //物料收入编辑页面跳转
    @RequestMapping("/materialReceive/edit")
    public ModelAndView editMaterialReceive(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/jsp/materialReceive_edit.jsp");
        return modelAndView;
    }
    //物料收入数据库更新
    @RequestMapping("/materialReceive/update_all")
    @ResponseBody
    public Map<String,Object> updateMaterialReceive(MaterialReceive materialReceive){
        int i = materialService.updateMaterialReceive(materialReceive);
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
    @RequestMapping("/materialReceive/delete_judge")
    @ResponseBody
    public String deleteMaterialReceiveConfirm(){
        return "{}";
    }
    //物料从数据库删除
    @RequestMapping("/materialReceive/delete_batch")
    @ResponseBody
    public Map<String,Object> deleteMaterialReceive(String[] ids){
        int i = 0;
        for(String id : ids){
            i += materialService.deleteMaterialReceive(id);
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
    //物料收入搜索——物料收入编号
    @RequestMapping("/materialReceive/search_materialReceive_by_receiveId")
    @ResponseBody
    public Page<MaterialReceives> searchMaterialReceiveByReceiveId(String searchValue,int page,int rows){
        Page<MaterialReceives> materialReceivePage = materialService.searchMaterialReceiveByReceiveId(searchValue, page, rows);
        return materialReceivePage;
    }
    //物料收入搜索——物料编号
    @RequestMapping("/materialReceive/search_materialReceive_by_materialId")
    @ResponseBody
    public Page<MaterialReceives>searchMaterialReceiveByMaterialId (String searchValue,int page,int rows){
        Page<MaterialReceives> materialReceivePage = materialService.searchMaterialReceiveByMaterialId(searchValue, page, rows);
        return materialReceivePage;
    }

    //物料信息详情
    @RequestMapping("/material/get/{materialId}")
    @ResponseBody
    public Material getMaterial(@PathVariable("materialId") String materialId){
        Material material = materialService.selectOneMaterial(materialId);
        return material;
    }

    //物料收入详情更新
    @RequestMapping("/materialReceive/update_note")
    @ResponseBody
    public Map<String ,Object> materialReceiveDetails(String receiveId,String note){
        int i = materialService.updateMaterialReceiveDetail(receiveId,note);
        Map<String, Object> map = new HashMap<>();
        if(i==1){
            map.put("status",200);
            map.put("msg","ok");
        }else{
            map.put("data","error");
        }
        return map;
    }
}
