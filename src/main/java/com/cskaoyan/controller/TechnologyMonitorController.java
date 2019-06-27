package com.cskaoyan.controller;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.Process;
import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyPlan;
import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.mapper.TechnologyMapper;
import com.cskaoyan.service.ProcessService;
import com.cskaoyan.service.TechnologyPlanService;
import com.cskaoyan.service.TechnologyRequirementService;
import com.cskaoyan.service.TechnologyService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sun.security.timestamp.TSRequest;

import javax.servlet.http.HttpSession;
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

    //注入spring自带的HTTPSession，用于设置sysPermissionList
    @Autowired
    HttpSession session;

    @Autowired
    TechnologyService technologyService;
    //一.工艺管理
    //URL：technology/find，technology/list?page=1&rows=30
    @RequestMapping("/technology/find")
    public ModelAndView technologyFind(){
        ModelAndView modelAndView = new ModelAndView();

        String[] sysPermissionList = {"technology:add","technology:edit","technology:delete"};
        session.setAttribute("sysPermissionList",sysPermissionList);

        modelAndView.setViewName("/WEB-INF/jsp/technology_list.jsp");
        return modelAndView;
    }



    @RequestMapping("/technology/list")
    @ResponseBody
    public Page<Technology> technologyList(int page, int rows){
        Page<Technology> technologyPage = technologyService.selectTechnologyPage(page, rows);
        return technologyPage;
    }


    @Autowired
    TechnologyRequirementService requirementService;
    //二.工艺要求
    @RequestMapping("/technologyRequirement/find")
    public ModelAndView technologyRequirementFind(){
        ModelAndView modelAndView = new ModelAndView();
        String[] sysPermissionList = {"technologyRequirement:add","technologyRequirement:edit","technologyRequirement:delete"};
        session.setAttribute("sysPermissionList",sysPermissionList);
        modelAndView.setViewName("/WEB-INF/jsp/technologyRequirement_list.jsp");
        return modelAndView;
    }


    @RequestMapping("/technologyRequirement/list")
    @ResponseBody
    public Page<TechnologyRequirement> technologyRequirementList(int page, int rows){
        Page<TechnologyRequirement> technologyRequirementPage = requirementService.selectTechReqPage(page, rows);
        return technologyRequirementPage;
    }

    //三.工艺计划

    @Autowired
    TechnologyPlanService planService;

    @RequestMapping("/technologyPlan/find")
    public ModelAndView technologyPlanFind(){
        ModelAndView modelAndView = new ModelAndView();
        String[] sysPermissionList = {"technologyPlan:add","technologyPlan:edit","technologyPlan:delete"};
        session.setAttribute("sysPermissionList",sysPermissionList);
        modelAndView.setViewName("/WEB-INF/jsp/technologyPlan_list.jsp");
        return modelAndView;
    }

    @RequestMapping("/technologyPlan/list")
    @ResponseBody
    public Page<TechnologyPlan> technologyPlanList(int page, int rows){
        Page<TechnologyPlan> technologyPlanPage = planService.selectTechPlanPage(page, rows);
        return technologyPlanPage;
    }


    //四.工序管理

    @Autowired
    ProcessService processService;

    @RequestMapping("/process/find")
    public ModelAndView processFind(){
        ModelAndView modelAndView = new ModelAndView();
        String[] sysPermissionList = {"process:add","process:edit","process:delete"};
        session.setAttribute("sysPermissionList",sysPermissionList);
        modelAndView.setViewName("/WEB-INF/jsp/process_list.jsp");

        return modelAndView;
    }

    @RequestMapping("/process/list")
    @ResponseBody
    public Page<Process> processList(int page, int rows){
        Page<Process> processPage = processService.selectProcessPage(page, rows);
        return processPage;
    }

    @RequestMapping("/technology/get_data")
    @ResponseBody
    public List<Technology> getTechnologyList(){
        List<Technology> technologies = technologyService.selectTechnologys();
        return technologies;
    }

    @RequestMapping("/technologyPlan/get/{technologyPlanId}")
    @ResponseBody
    public TechnologyPlan getTechnologyPlanById(@PathVariable("technologyPlanId") String technologyPlanId){
        TechnologyPlan technologyPlan = planService.selectTechPlanById(technologyPlanId);
        return technologyPlan;
    }




}
