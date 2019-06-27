package com.cskaoyan.controller.material;

import com.cskaoyan.bean.material.Material;
import com.cskaoyan.bean.material.MaterialConsume;
import com.cskaoyan.bean.material.MaterialReceive;
import com.cskaoyan.bean.material.MaterialReceives;
import com.cskaoyan.mapper.material.MaterialMapper;
import com.cskaoyan.service.material.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class MaterialMonitorController {
    @Autowired
    MaterialService materialService;

    //物料信息
    @RequestMapping("/material/find")
    public ModelAndView findMaterial(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/jsp/material_list.jsp");
        return modelAndView;
    }
    @RequestMapping("/material/list")
    @ResponseBody
    public List<Material> materialList(){
        List<Material> materials = materialService.queryMaterialList();
        System.out.println(materials);
        return materials;
    }

    //物料收入
    @RequestMapping("/materialReceive/find")
    public ModelAndView findMaterialReceive(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/jsp/materialReceive_list.jsp");
        return modelAndView;
    }
    @RequestMapping("/materialReceive/list")
    @ResponseBody
    public Map<String, Object> materialReceiveList(){
        Map<String, Object> materialReceives = materialService.allMaterialReceives();
        System.out.println(materialReceives);
        return materialReceives;
    }
    //物料消耗
    @RequestMapping("/materialConsume/find")
    public ModelAndView findMaterialConsume(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/jsp/materialConsume_list.jsp");
        return modelAndView;
    }
    @RequestMapping("/materialConsume/list")
    @ResponseBody
    public Map<String, Object> materialConsumeList(){
        Map<String, Object> consumes = materialService.allMaterialConsumes();
        System.out.println(consumes);
        return consumes;
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
