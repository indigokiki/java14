package com.cskaoyan.controller.technology;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.technology.Process;
import com.cskaoyan.bean.technology.Technology;
import com.cskaoyan.bean.technology.TechnologyPlan;
import com.cskaoyan.bean.technology.TechnologyRequirement;
import com.cskaoyan.service.technology.ProcessService;
import com.cskaoyan.service.technology.TechnologyPlanService;
import com.cskaoyan.service.technology.TechnologyRequirementService;
import com.cskaoyan.service.technology.TechnologyService;
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
    * 模糊查询*/
    @RequestMapping("/technology/search_technology_by_technologyId")
    @ResponseBody
    public Page<Technology> searchTechPageById(String searchValue, int page, int rows){
        Page<Technology> technologyPage = technologyService.searchTechPageByVagueId(searchValue, page, rows);
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
            responseVo.setMsg("编辑失败！");
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
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("删除失败！");
        }
        return responseVo;
    }


    //二.工艺要求

    @Autowired
    TechnologyRequirementService requirementService;

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
    //模糊搜索
    @RequestMapping("/technologyRequirement/search_technologyRequirement_by_technologyRequirementId")
    @ResponseBody
    public Page<TechnologyRequirement> searchTechReqPageById(String searchValue, int page, int rows){
        Page<TechnologyRequirement> technologyRequirementPage = requirementService.searchTechReqPageByVagueId(searchValue, page, rows);
        return technologyRequirementPage;
    }


    //工艺名称搜索
    //精确搜索
    @RequestMapping("/technologyRequirement/search_technologyRequirement_by_technologyName")
    @ResponseBody
    public Page<TechnologyRequirement> searchTechReqPageByTechName(String searchValue, int page, int rows){
        Page<TechnologyRequirement> requirementPage = requirementService.searchTechReqPageByVagueTechnologyName(searchValue, page, rows);
        return requirementPage;
    }


    /*工艺要求-新增*/
    @RequestMapping("/technologyRequirement/add_judge")
    @ResponseBody
    public String technologyRequirementAddJudge(){
        return "{}";
    }

    @RequestMapping("/technologyRequirement/add")
    public ModelAndView technologyRequirementAdd(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/jsp/technologyRequirement_add.jsp");
        return modelAndView;
    }

    @RequestMapping("/technologyRequirement/get_data")
    @ResponseBody
    public List<TechnologyRequirement> getTechnologyRequirement(){
        List<TechnologyRequirement> requirementList = requirementService.selectTechReqs();
        return requirementList;
    }



    @RequestMapping("/technologyRequirement/insert")
    @ResponseBody
    public ResponseVo technologyRequirementInsert(TechnologyRequirement requirement){
        int i = requirementService.insertRequirement(requirement);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (i == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("该工艺要求编号已经存在，请更换工艺要求编号！");
        }

        return responseVo;
    }

    /*工艺要求-修改*/
    @RequestMapping("/technologyRequirement/edit_judge")
    @ResponseBody
    public String technologyRequirementEditJudge(){
        return "{}";
    }


    @RequestMapping("/technologyRequirement/edit")
    public ModelAndView technologyRequirementEdit(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/jsp/technologyRequirement_edit.jsp");
        return modelAndView;
    }

    @RequestMapping("technologyRequirement/update_all")
    @ResponseBody
    public ResponseVo technologyRequirementUpdate(TechnologyRequirement requirement){
        int i = requirementService.updateRequirement(requirement);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (i == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("编辑失败！");
        }

        return responseVo;
    }


    @RequestMapping("/technologyRequirement/update_requirement")
    @ResponseBody
    public ResponseVo updateRequirementById(String technologyRequirementId, String requirement){
        int i = requirementService.updateRequirementOnlyById(technologyRequirementId, requirement);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (i == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("编辑失败！");
        }

        return responseVo;
    }



    /*工艺要求-删除*/
    @RequestMapping("/technologyRequirement/delete_judge")
    @ResponseBody
    public String technologyRequirementDeleJudge(){
        return "{}";
    }


    @RequestMapping("/technologyRequirement/delete_batch")
    @ResponseBody
    public ResponseVo technologyRequirementDelete(String[] ids){
        int i = 0 ;
        for(String technologyRequirementId : ids){
            i += requirementService.deleteRequirementById(technologyRequirementId);
        }
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (i == ids.length){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("删除失败！");
        }
        return responseVo;
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


    //工艺计划编号搜索
    //模糊搜索
    @RequestMapping("/technologyPlan/search_technologyPlan_by_technologyPlanId")
    @ResponseBody
    public Page<TechnologyPlan> searchPlanPageById(String searchValue, int page, int rows){
        Page<TechnologyPlan> planPage = planService.searchPlanPageByVagueId(searchValue, page, rows);
        return planPage;
    }

    //工艺名称搜索
    @RequestMapping("/technologyPlan/search_technologyPlan_by_technologyName")
    @ResponseBody
    public Page<TechnologyPlan> searchPlanPageByTechName(String searchValue, int page, int rows){
        Page<TechnologyPlan> planPage = planService.searchTechReqPageByVagueTechnologyName(searchValue, page, rows);
        return planPage;
    }


    /*工艺计划-新增*/
    @RequestMapping("/technologyPlan/add_judge")
    @ResponseBody
    public String technologyPlanAddJudge(){
        return "{}";
    }
    @RequestMapping("/technologyPlan/add")
    public ModelAndView technologyPlanAdd(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/jsp/technologyPlan_add.jsp");
        return modelAndView;
    }


    @RequestMapping("/technologyPlan/insert")
    @ResponseBody
    public ResponseVo technologyPlanInsert(TechnologyPlan technologyPlan){
        int i = planService.insertPlan(technologyPlan);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (i == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("该工艺计划编号已经存在，请更换工艺计划编号！");
        }

        return responseVo;
    }

    /*工艺计划-修改*/
    @RequestMapping("/technologyPlan/edit_judge")
    @ResponseBody
    public String technologyPlanEditJudge(){
        return "{}";
    }


    @RequestMapping("/technologyPlan/edit")
    public ModelAndView technologyPlanEdit(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/jsp/technologyPlan_edit.jsp");
        return modelAndView;
    }

    @RequestMapping("/technologyPlan/update_all")
    @ResponseBody
    public ResponseVo technologyPlanUpdate(TechnologyPlan technologyPlan){
        int i = planService.updatePlan(technologyPlan);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (i == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("编辑失败！");
        }

        return responseVo;
    }

    /*工艺计划-删除*/
    @RequestMapping("/technologyPlan/delete_judge")
    @ResponseBody
    public String technologyPlanDeleJudge(){
        return "{}";
    }


    @RequestMapping("/technologyPlan/delete_batch")
    @ResponseBody
    public ResponseVo technologyPlanDelete(String[] ids){
        int i = 0 ;
        for(String technologyPlanId : ids){
            i += planService.deletePlan(technologyPlanId);
        }
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (i == ids.length){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("删除失败！");
        }
        return responseVo;
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


    //工序编号搜索
    @RequestMapping("/process/search_process_by_processId")
    @ResponseBody
    public Page<Process> searProcessPageById(String searchValue, int page, int rows){
        Page<Process> processPage = processService.searchProcessPageByVagueId(searchValue, page, rows);
        return processPage;
    }

    //工艺名称搜索：technology/search_technology_by_technologyName
    @RequestMapping("/process/search_process_by_technologyPlanId")
    @ResponseBody
    public Page<Process> searchProcessPageByPlanId(String searchValue, int page, int rows){
        Page<Process> processPage = processService.searchProcessPageByVaguePlanId(searchValue, page, rows);
        return processPage;
    }




    //technologyPlan/get_data在QualityMonitorController.java里
    /*工序管理-新增*/
    @RequestMapping("/process/add_judge")
    @ResponseBody
    public String processAddJudge(){
        return "{}";
    }

    @RequestMapping("/process/add")
    public ModelAndView processAdd(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/jsp/process_add.jsp");
        return modelAndView;
    }


    @RequestMapping("/process/insert")
    @ResponseBody
    public ResponseVo processInsert(Process process){
        int i = processService.insertProcess(process);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (i == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("该工序管理已经存在，请更换工序管理编号！");
        }

        return responseVo;
    }

    /*工序管理-修改*/
    @RequestMapping("/process/edit_judge")
    @ResponseBody
    public String processEditJudge(){
        return "{}";
    }


    @RequestMapping("/process/edit")
    public ModelAndView processEdit(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/jsp/process_edit.jsp");
        return modelAndView;
    }

    @RequestMapping("/process/update_all")
    @ResponseBody
    public ResponseVo processUpdate(Process process){
        int i = processService.updateProcess(process);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (i == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("编辑失败！");
        }

        return responseVo;
    }

    /*工序管理-删除*/
    @RequestMapping("/process/delete_judge")
    @ResponseBody
    public String processDeleJudge(){
        return "{}";
    }


    @RequestMapping("/process/delete_batch")
    @ResponseBody
    public ResponseVo processDelete(String[] ids){
        int i = 0 ;
        for(String processId : ids){
            i += processService.deleteProcess(processId);
        }
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (i == ids.length){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("删除失败！");
        }
        return responseVo;
    }



}
