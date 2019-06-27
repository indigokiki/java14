package com.cskaoyan.controller;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.mapper.TechnologyMapper;
import com.cskaoyan.service.TechnologyRequirementService;
import com.cskaoyan.service.TechnologyService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sun.security.timestamp.TSRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author YangShuo
 * @date 2019-06-26 15:33
 */
/*工艺监控部分--杨朔*/
@Controller
public class TechnologyMonitorController {





    //测试静态资源如图片的加载，成功
    @RequestMapping("/rs")
    public String toRSTest(){
        return "/WEB-INF/jsp/login.jsp";
    }


    //测试用,主页
    @RequestMapping(value = {"/home","/"})
    public String toHome(){
        return "/WEB-INF/jsp/home.jsp";
    }

    @Autowired
    TechnologyService technologyService;

    //一.工艺管理
    //URL：technology/find，technology/list?page=1&rows=30
    @RequestMapping("/technology/find")
    public ModelAndView technologyFind(){
        ModelAndView modelAndView = new ModelAndView();

        String[] sysPermissionList = {"technology:add","technology:edit","technology:delete"};
        modelAndView.addObject("sysPermissionList",sysPermissionList);

        modelAndView.setViewName("/WEB-INF/jsp/technology_list.jsp");
        return modelAndView;
    }


    @RequestMapping("/technology/list")
    @ResponseBody
    public Map<String, Object> technologyList(){
        HashMap<String, Object> map = new HashMap<>();
        List<Technology> technologyList = technologyService.selectTechnologys();
        String total = "7";
        map.put("total",total);
        map.put("rows",technologyList);
        return map;
    }


    @Autowired
    TechnologyRequirementService requirementService;
    //二.工艺要求
    @RequestMapping("/technologyRequirement/find")
    public ModelAndView technologyRequirementFind(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/jsp/technologyRequirement_list.jsp");
        return modelAndView;
    }


    @RequestMapping("/technologyRequirement/list")
    @ResponseBody
    public Map<String, Object> technologyRequirementList(){
        HashMap<String, Object> map = new HashMap<>();
        List<TechnologyRequirement> technologyRequirementList = requirementService.selectTechReqs();
        String total = "5";
        map.put("total",total);
        map.put("rows",technologyRequirementList);
        return map;
    }

    //三.工艺计划



    //四.工序管理

}
