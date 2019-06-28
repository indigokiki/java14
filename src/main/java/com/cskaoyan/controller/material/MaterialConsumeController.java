package com.cskaoyan.controller.material;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.material.MaterialConsume;
import com.cskaoyan.bean.material.MaterialConsumes;
import com.cskaoyan.bean.material.MaterialReceive;
import com.cskaoyan.bean.material.MaterialReceives;
import com.cskaoyan.mapper.material.MaterialMapper;
import com.cskaoyan.service.material.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author IL-M
 * @Date:2019/6/28 10:49
 */
@Controller
public class MaterialConsumeController {
    @Autowired
    MaterialService materialService;

    @Autowired
    HttpSession session;

    //物料消耗数据展示
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

    //物料消耗新增判断
    @RequestMapping("/materialConsume/add_judge")
    @ResponseBody
    public String addMaterialConsumejudge(){
        return "{}";
    }
   //物料消耗新增页面跳转
    @RequestMapping("/materialConsume/add")
    public ModelAndView addMaterialConsume(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/jsp/materialConsume_add.jsp");
        return modelAndView;
    }
    //物料消耗新增到数据库
    @RequestMapping("/materialConsume/insert")
    @ResponseBody
    public Map<String,Object> insertMaterialConsume(MaterialConsume materialConsume){
        int i = materialService.insertMaterialConsume(materialConsume);
        Map<String, Object> map = new HashMap<>();
        if(i==1){
            map.put("status",200);
            map.put("msg","ok");
        }else{
            map.put("data","error");
        }
        return map;
    }
   //物料消耗編輯判斷
    @RequestMapping("/materialConsume/edit_judge")
    @ResponseBody
    public String editMaterialConsumejudge(){
        return "{}";
    }
    //物料消耗编辑页面跳转
    @RequestMapping("/materialConsume/edit")
    public ModelAndView editMaterialConsume(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/jsp/materialConsume_edit.jsp");
        return modelAndView;
    }
    //物料消耗数据库更新
    @RequestMapping("/materialConsume/update_all")
    @ResponseBody
    public Map<String,Object> updateMaterialConsume(MaterialConsume materialConsume){
        int i = materialService.updateMaterialConsume(materialConsume);
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
    @RequestMapping("/materialConsume/delete_judge")
    @ResponseBody
    public String deleteMaterialConsumeConfirm(){
        return "{}";
    }
    //物料从数据库删除
    @RequestMapping("/materialConsume/delete_batch")
    @ResponseBody
    public Map<String,Object> deleteMaterialConsume(String[] ids){
        int i = 0;
        for(String id : ids){
            i += materialService.deleteMaterialConsume(id);
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
    //物料消耗搜索——物料消耗编号
    @RequestMapping("/materialConsume/search_materialConsume_by_consumeId")
    @ResponseBody
    public Page<MaterialConsumes> searchMaterialReceiveByConsumeId(String searchValue,int page,int rows){
        Page<MaterialConsumes> materialConsumePage = materialService.searchMaterialReceiveByConsumeId(searchValue, page, rows);
        return materialConsumePage;
    }
    //物料消耗搜索——物料编号
    @RequestMapping("/materialConsume/search_materialConsume_by_materialId")
    @ResponseBody
    public Page<MaterialConsumes>searchMaterialConsumeByMaterialId (String searchValue,int page,int rows){
        Page<MaterialConsumes> materialConsumePage = materialService.searchMaterialConsumeByMaterialId(searchValue, page, rows);
        return materialConsumePage;
    }
    //物料消耗搜索——作业编号
    @RequestMapping("/materialConsume/search_materialConsume_by_workId")
    @ResponseBody
    public Page<MaterialConsumes>searchMaterialConsumeByWorkId (String searchValue,int page,int rows){
        Page<MaterialConsumes> materialConsumePage = materialService.searchMaterialConsumeByWorkId(searchValue, page, rows);
        return materialConsumePage;
    }

    //物料消耗详情更新
    @RequestMapping("/materialConsume/update_note")
    @ResponseBody
    public Map<String ,Object> materialConsumeDetails(String consumeId,String note){
        int i = materialService.updateMaterialConsumeDetail(consumeId,note);
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
