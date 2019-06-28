package com.cskaoyan.controller.qualitymonitor;

import com.cskaoyan.bean.*;
import com.cskaoyan.bean.technology.Process;
import com.cskaoyan.bean.technology.TechnologyPlan;
import com.cskaoyan.service.qualitymonitor.QualityMonitorService;
import com.cskaoyan.vo.ResponseVo;
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

    @RequestMapping("unqualify/delete_judge")
    public String unqualifydeletejudge(){
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
    public ResponseVo unqualifyinsert(UnqualifyApply unqualifyApply){
        int status = qualityMonitorService.addUnqualifyApply(unqualifyApply);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (status == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("操作失败！请联系管理员！");
        }
        return responseVo;
    }

    @RequestMapping("unqualify/update_all")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ResponseVo unqualifyupdate(UnqualifyApply unqualifyApply){
        int status = qualityMonitorService.updateUnqualifyApply(unqualifyApply);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (status == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("操作失败！请联系管理员！");
        }
        return responseVo;
    }

    @RequestMapping("unqualify/delete_batch")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ResponseVo unqualifydelete(String[] ids){
        int status = qualityMonitorService.deleteUnqualifyApply(ids);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (status == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("操作失败！请联系管理员！");
        }
        return responseVo;
    }


    @RequestMapping("unqualify/search_unqualify_by_unqualifyId")
    public Page unqualifysearchbyid(String searchValue,int page,int rows){
        return qualityMonitorService.searchUnqualifyApplyById(searchValue,page,rows);
    }


    @RequestMapping("unqualify/search_unqualify_by_productName")
    public Page unqualifysearchbyproductname(String searchValue,int page,int rows){
        return qualityMonitorService.searchUnqualifyApplyByProductName(searchValue,page,rows);
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

    @RequestMapping("fMeasureCheck/delete_judge")
    public String measuredeletejudge(){
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
    public ResponseVo measureinsert(FinalMeasuretCheck finalMeasuretCheck){
        int status = qualityMonitorService.addFinalMeasuretCheck(finalMeasuretCheck);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (status == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("操作失败！请联系管理员！");
        }
        return responseVo;
    }

    @RequestMapping("measure/update_all")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ResponseVo measureupdate(FinalMeasuretCheck finalMeasuretCheck){
        int status = qualityMonitorService.updateFinalMeasuretCheck(finalMeasuretCheck);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (status == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("操作失败！请联系管理员！");
        }
        return responseVo;
    }

    @RequestMapping("measure/delete_batch")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ResponseVo measuredelete(String[] ids){
        int status = qualityMonitorService.deleteFinalMeasuretCheck(ids);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (status == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("操作失败！请联系管理员！");
        }
        return responseVo;
    }

    @RequestMapping("measure/search_fMeasureCheck_by_fMeasureCheckId")
    public Page measuresearchbyid(String searchValue,int page,int rows){
        return qualityMonitorService.searchMeasurePageById(searchValue,page,rows);
    }

    @RequestMapping("measure/search_fMeasureCheck_by_orderId")
    public Page measuresearchbyorderid(String searchValue,int page,int rows){
        return qualityMonitorService.searchMeasurePageByOrderId(searchValue,page,rows);
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

    @RequestMapping("fCountCheck/delete_judge")
    public String fcountcheckdeletejudge(){
        return "{}";
    }

    @RequestMapping("f_count_check/insert")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ResponseVo fcountcheckinsert(FinalCountCheck finalCountCheck){
        int status = qualityMonitorService.addFinalCountCheck(finalCountCheck);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (status == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("操作失败！请联系管理员！");
        }
        return responseVo;
    }

    @RequestMapping("f_count_check/update_all")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ResponseVo fcountcheckupdate(FinalCountCheck finalCountCheck){
        int status = qualityMonitorService.updateFinalCountCheck(finalCountCheck);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (status == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("操作失败！请联系管理员！");
        }
        return responseVo;
    }

    @RequestMapping("f_count_check/delete_batch")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ResponseVo fcountcheckdelete(String[] ids){
        int status = qualityMonitorService.deleteFinalCountCheck(ids);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (status == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("操作失败！请联系管理员！");
        }
        return responseVo;
    }

    @RequestMapping("f_count_check/search_fCountCheck_by_fCountCheckId")
    public Page fcountchecksearchbyid(String searchValue,int page,int rows){
        return qualityMonitorService.searchFCountCheckPageById(searchValue,page,rows);
    }

    @RequestMapping("f_count_check/search_fCountCheck_by_orderId")
    public Page fcountchecksearchbyorderid(String searchValue,int page,int rows){
        return qualityMonitorService.searchFCountCheckPageByOrderId(searchValue,page,rows);
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

    @RequestMapping("pMeasureCheck/delete_judge")
    public String pmeasurecheckdeletejudge(){
        return "{}";
    }

    @RequestMapping("p_measure_check/insert")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ResponseVo pmeasurecheckinsert(ProcessMeasureCheck processMeasureCheck){
        int status = qualityMonitorService.addProcessMeasureCheck(processMeasureCheck);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (status == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("操作失败！请联系管理员！");
        }
        return responseVo;
    }

    @RequestMapping("p_measure_check/update_all")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ResponseVo pmeasurecheckupdate(ProcessMeasureCheck processMeasureCheck){
        int status = qualityMonitorService.updateProcessMeasureCheck(processMeasureCheck);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (status == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("操作失败！请联系管理员！");
        }
        return responseVo;
    }

    @RequestMapping("p_measure_check/delete_batch")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ResponseVo pmeasurecheckdelete(String[] ids){
        int status = qualityMonitorService.deleteProcessMeasureCheck(ids);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (status == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("操作失败！请联系管理员！");
        }
        return responseVo;
    }

    @RequestMapping("p_measure_check/search_pMeasureCheck_by_pMeasureCheckId")
    public Page pmeasurechecksearchbyid(String searchValue,int page,int rows){
        return qualityMonitorService.searchPMeasureCheckPageById(searchValue,page,rows);
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

    @RequestMapping("pCountCheck/delete_judge")
    public String pcountcheckdeletejudge(){
        return "{}";
    }

    @RequestMapping("p_count_check/insert")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ResponseVo pcountcheckinsert(ProcessCountCheck processCountCheck){
        int status = qualityMonitorService.addProcessCountCheck(processCountCheck);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (status == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("操作失败！请联系管理员！");
        }
        return responseVo;
    }

    @RequestMapping("p_count_check/update_all")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ResponseVo pcountcheckupdate(ProcessCountCheck processCountCheck){
        int status = qualityMonitorService.updateProcessCountCheck(processCountCheck);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (status == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("操作失败！请联系管理员！");
        }
        return responseVo;
    }

    @RequestMapping("p_count_check/delete_batch")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ResponseVo pcountcheckdelete(String[] ids){
        int status = qualityMonitorService.deleteProcessCountCheck(ids);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (status == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("操作失败！请联系管理员！");
        }
        return responseVo;
    }

    @RequestMapping("p_count_check/search_pCountCheck_by_pCountCheckId")
    public Page pcountchecksearchbyid(String searchValue,int page,int rows){
        return qualityMonitorService.searchPCountCheckPageById(searchValue,page,rows);
    }








    @RequestMapping("department/get_data")
    public List<Department> depgetdata(){
        return qualityMonitorService.getDepartmentList();
    }

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

    @RequestMapping("order/get_data")
    public List<OrderByRevEngineering> ordergetdata(){
        return qualityMonitorService.getOrderList();
    }

    @RequestMapping("process/get_data")
    public List<Process> processgetdata(){
        return qualityMonitorService.getProcessList();
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
