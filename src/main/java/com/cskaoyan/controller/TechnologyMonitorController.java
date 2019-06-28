package com.cskaoyan.controller;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.Process;
import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyPlan;
import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.service.ProcessService;
import com.cskaoyan.service.TechnologyPlanService;
import com.cskaoyan.service.TechnologyRequirementService;
import com.cskaoyan.service.TechnologyService;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    @RequestMapping("/technology/get/{technologyId}")
    @ResponseBody
    public Technology getTechnologyById(@PathVariable("technologyId") String technologyId){
        Technology technology = technologyService.selectTechnologyById(technologyId);
        return technology;
    }

    /*工艺编号搜索：technology/search_technology_by_technologyId
    * 精确查询*/
    @RequestMapping("/technology/search_technology_by_technologyId")
    @ResponseBody
    public Page<Technology> searchTechPageById(String searchValue){
        Page<Technology> technologyPage = technologyService.searchTechPageById(searchValue);
        return technologyPage;
    }

    /*工艺名称搜索：technology/search_technology_by_technologyName
    * 模糊查询*/
    @RequestMapping("/technology/search_technology_by_technologyName")
    @ResponseBody
    public Page<Technology> searchTechPageByName(String searchValue, int page, int rows){
        Page<Technology> technologyPage = technologyService.searchTechPageByVagueName(searchValue, page, rows);
        return technologyPage;
    }

    /*工艺管理-新增*/
    @RequestMapping("/technology/add_judge")
    @ResponseBody
    public String technologyAddJudge(){
        return "{}";
    }

    @RequestMapping("/technology/add")
    public ModelAndView technologyAdd(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/jsp/technology_add.jsp");
        return modelAndView;
    }


    @RequestMapping("/technology/insert")
    @ResponseBody
    public ResponseVo technologyInsert(Technology technology){
        int i = technologyService.insertTechnology(technology);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (i == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("该工艺编号已经存在，请更换工艺编号！");
        }

        return responseVo;
    }

    /*工艺管理-修改*/
    @RequestMapping("/technology/edit_judge")
    @ResponseBody
    public String technologyEditJudge(){
        return "{}";
    }


    @RequestMapping("/technology/edit")
    public ModelAndView technologyEdit(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/jsp/technology_edit.jsp");
        return modelAndView;
    }

    @RequestMapping("/technology/update_all")
    @ResponseBody
    public ResponseVo technologyUpdate(Technology technology){
        int i = technologyService.updateTechnology(technology);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (i == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("编辑工艺失败！");
        }

        return responseVo;
    }

    /*工艺管理-删除*/
    @RequestMapping("/technology/delete_judge")
    @ResponseBody
    public String technologyDeleJudge(){
        return "{}";
    }


    @RequestMapping("/technology/delete_batch")
    @ResponseBody
    public ResponseVo technologyDelete(String[] ids){
        int i = 0 ;
        for(String technologyId : ids){
            i += technologyService.deleteTechnologyById(technologyId);
        }
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (i == ids.length){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }
        return responseVo;
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

    //工艺要求编号搜索：technologyRequirement/search_technologyRequirement_by_technologyRequirementId
    @RequestMapping("/technologyRequirement/search_technologyRequirement_by_technologyRequirementId")
    @ResponseBody
    public Page<TechnologyRequirement> searchTechReqPageById(String searchValue){
        Page<TechnologyRequirement> technologyRequirementPage = requirementService.searchTechReqPageById(searchValue);
        return technologyRequirementPage;
    }


    //工艺名称搜索：technologyRequirement/search_technologyRequirement_by_technologyName
    //精确搜索
    @RequestMapping("/technologyRequirement/search_technologyRequirement_by_technologyName")
    @ResponseBody
    public Page<TechnologyRequirement> searchTechReqPageByTechName(String searchValue, int page, int rows){
        Page<TechnologyRequirement> requirementPage = requirementService.searchTechReqPageByTechnologyName(searchValue, page, rows);
        return requirementPage;
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