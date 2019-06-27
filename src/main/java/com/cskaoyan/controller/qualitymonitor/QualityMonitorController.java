package com.cskaoyan.controller.qualitymonitor;

import com.cskaoyan.bean.*;
import com.cskaoyan.service.qualitymonitor.QualityMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
public class QualityMonitorController {

    @Autowired
    QualityMonitorService qualityMonitorService;

    @RequestMapping("unqualify/find")
    public ModelAndView unqualifyfind(ModelAndView modelAndView, HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        List<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("unqualify:add");
        sysPermissionList.add("unqualify:edit");
        sysPermissionList.add("unqualify:delete");
        session.setAttribute("sysPermissionList",sysPermissionList);
        modelAndView.setViewName("/WEB-INF/jsp/unqualify_list.jsp");
        return modelAndView;
    }

    @RequestMapping("unqualify/add_judge")
    public String unqualifyadd(){
        return "{}";
    }

    @RequestMapping("unqualify/edit_judge")
    public String unqualifyeditjudge(){
        return "{}";
    }

    @RequestMapping("unqualify/add")
    public ModelAndView unqualifyadd(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/unqualify_add.jsp");
        return modelAndView;
    }


    @RequestMapping("unqualify/edit")
    public ModelAndView unqualifyedit(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/unqualify_edit.jsp");
        return modelAndView;
    }

    @RequestMapping("unqualify/insert")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public String unqualifyinsert(UnqualifyApply unqualifyApply){
        int status = qualityMonitorService.addUnqualifyApply(unqualifyApply);
        if(1 == status){
            return "{\"status\":200,\"msg\":\"OK\",\"data\":null}";
        }
        return "{\"status\":0,\"msg\":\"ERROR\",\"data\":add failed!}";
    }

    @RequestMapping("measure/find")
    public ModelAndView measurefind(ModelAndView modelAndView,HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        List<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("fMeasureCheck:add");
        sysPermissionList.add("fMeasureCheck:edit");
        sysPermissionList.add("fMeasureCheck:delete");
        session.setAttribute("sysPermissionList",sysPermissionList);
        modelAndView.setViewName("/WEB-INF/jsp/measurement_list.jsp");
        return modelAndView;
    }

    @RequestMapping("fMeasureCheck/add_judge")
    public String measureadd(){
        return "{}";
    }

    @RequestMapping("fMeasureCheck/edit_judge")
    public String measureeditjudge(){
        return "{}";
    }

    @RequestMapping("measure/add")
    public ModelAndView measureadd(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/measurement_add.jsp");
        return modelAndView;
    }

    @RequestMapping("measure/edit")
    public ModelAndView measureedit(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/measurement_edit.jsp");
        return modelAndView;
    }


    @RequestMapping("measure/insert")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public String measureinsert(FinalMeasuretCheck finalMeasuretCheck){
        int status = qualityMonitorService.addFinalMeasuretCheck(finalMeasuretCheck);
        if(1 == status){
            return "{\"status\":200,\"msg\":\"OK\",\"data\":null}";
        }
        return "{\"status\":0,\"msg\":\"ERROR\",\"data\":add failed!}";
    }

    @RequestMapping("f_count_check/find")
    public ModelAndView fcountcheckfind(ModelAndView modelAndView,HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        List<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("fCountCheck:add");
        sysPermissionList.add("fCountCheck:edit");
        sysPermissionList.add("fCountCheck:delete");
        session.setAttribute("sysPermissionList",sysPermissionList);
        modelAndView.setViewName("/WEB-INF/jsp/f_count_check_list.jsp");
        return modelAndView;
    }

    @RequestMapping("f_count_check/add")
    public ModelAndView fcountcheckadd(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/f_count_check_add.jsp");
        return modelAndView;
    }

    @RequestMapping("f_count_check/edit")
    public ModelAndView fcountcheckedit(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/f_count_check_edit.jsp");
        return modelAndView;
    }

    @RequestMapping("fCountCheck/add_judge")
    public String fcountcheckadd(){
        return "{}";
    }

    @RequestMapping("fCountCheck/edit_judge")
    public String fcountcheckeditjudge(){
        return "{}";
    }

    @RequestMapping("f_count_check/insert")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public String fcountcheckinsert(FinalCountCheck finalCountCheck){
        int status = qualityMonitorService.addFinalCountCheck(finalCountCheck);
        if(1 == status){
            return "{\"status\":200,\"msg\":\"OK\",\"data\":null}";
        }
        return "{\"status\":0,\"msg\":\"ERROR\",\"data\":add failed!}";
    }

    @RequestMapping("p_measure_check/find")
    public ModelAndView pmeasurecheckfind(ModelAndView modelAndView,HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        List<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("pMeasureCheck:add");
        sysPermissionList.add("pMeasureCheck:edit");
        sysPermissionList.add("pMeasureCheck:delete");
        session.setAttribute("sysPermissionList",sysPermissionList);
        modelAndView.setViewName("/WEB-INF/jsp/p_measure_check_list.jsp");
        return modelAndView;
    }

    @RequestMapping("p_measure_check/add")
    public ModelAndView pmeasurecheckadd(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/p_measure_check_add.jsp");
        return modelAndView;
    }

    @RequestMapping("p_measure_check/edit")
    public ModelAndView pmeasurecheckedit(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/p_measure_check_edit.jsp");
        return modelAndView;
    }

    @RequestMapping("pMeasureCheck/add_judge")
    public String pmeasurecheckadd(){
        return "{}";
    }

    @RequestMapping("pMeasureCheck/edit_judge")
    public String pmeasurecheckeditjudge(){
        return "{}";
    }

    @RequestMapping("p_measure_check/insert")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public String pmeasurecheckinsert(ProcessMeasureCheck processMeasureCheck){
        int status = qualityMonitorService.addProcessMeasureCheck(processMeasureCheck);
        if(1 == status){
            return "{\"status\":200,\"msg\":\"OK\",\"data\":null}";
        }
        return "{\"status\":0,\"msg\":\"ERROR\",\"data\":add failed!}";
    }

    @RequestMapping("p_count_check/find")
    public ModelAndView pcountcheckfind(ModelAndView modelAndView,HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        List<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("pCountCheck:add");
        sysPermissionList.add("pCountCheck:edit");
        sysPermissionList.add("pCountCheck:delete");
        session.setAttribute("sysPermissionList",sysPermissionList);
        modelAndView.setViewName("/WEB-INF/jsp/p_count_check_list.jsp");
        return modelAndView;
    }

    @RequestMapping("p_count_check/add")
    public ModelAndView pcountcheckadd(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/p_count_check_add.jsp");
        return modelAndView;
    }

    @RequestMapping("p_count_check/edit")
    public ModelAndView pcountcheckedit(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/p_count_check_edit.jsp");
        return modelAndView;
    }

    @RequestMapping("pCountCheck/add_judge")
    public String pcountcheckadd(){
        return "{}";
    }

    @RequestMapping("pCountCheck/edit_judge")
    public String pcountcheckeditjudge(){
        return "{}";
    }

    @RequestMapping("p_count_check/insert")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public String pcountcheckinsert(ProcessCountCheck processCountCheck){
        int status = qualityMonitorService.addProcessCountCheck(processCountCheck);
        if(1 == status){
            return "{\"status\":200,\"msg\":\"OK\",\"data\":null}";
        }
        return "{\"status\":0,\"msg\":\"ERROR\",\"data\":add failed!}";
    }








//    @RequestMapping("department/get_data")
//    public List<Department> depgetdata(){
//        return qualityMonitorService.getDepartmentList();
//    }
//
    @RequestMapping("custom/get_data")
    public List<Custom> cusgetdata(){
        return qualityMonitorService.getCustomList();
    }

    @RequestMapping("product/get_data")
    public List<Product> progetdata(){
        return qualityMonitorService.getProductList();
    }

    @RequestMapping("technologyPlan/get_data")
    public List<TechnologyPlan> techplangetdata(){
        return qualityMonitorService.getTechnologyPlanList();
    }






    @RequestMapping("unqualify/list*")
    public Page unqualifypage(int page,int rows){
        return qualityMonitorService.getUnqualifyPage(page,rows);
    }

    @RequestMapping("measure/list")
    public Page measurepage(int page,int rows) {
        return qualityMonitorService.getMeasurePage(page, rows);
    }

    @RequestMapping("f_count_check/list")
    public Page fcountcheck(int page,int rows){
        return  qualityMonitorService.getFCountCheckPage(page,rows);
    }

    @RequestMapping("p_measure_check/list")
    public Page pmeasurecheckpage(int page,int rows) {
        return qualityMonitorService.getPMeasureCheckPage(page, rows);
    }

    @RequestMapping("p_count_check/list")
    public Page pcountcheckpage(int page,int rows){
        return qualityMonitorService.getPCountCheckPage(page,rows);
    }

}
