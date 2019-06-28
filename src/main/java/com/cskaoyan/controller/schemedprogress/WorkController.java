package com.cskaoyan.controller.schemedprogress;

import com.cskaoyan.bean.Custom;
import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.Work;
import com.cskaoyan.bean.devman.DeviceType;
import com.cskaoyan.bean.schemedprogress.WorkMagger;
import com.cskaoyan.service.schemedprogress.WorkService;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class WorkController {

    @Autowired
    WorkService workService;

    @Autowired
    HttpSession session;

    @RequestMapping("work/find")
    public ModelAndView find(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/work_list.jsp");
        String[] sysPermissionList = {"work:add","work:edit","work:delete"};
        session.setAttribute("sysPermissionList",sysPermissionList);
        return modelAndView;
    }

    @RequestMapping("deviceType/get_data")
    @ResponseBody
    public List<DeviceType> getAllDeviceType(){
        List<DeviceType> allDeviceType = workService.getAllDeviceType();
        return allDeviceType;
    }

    @RequestMapping("work/list")
    @ResponseBody
    public WorkMagger getAllWork(String page, String rows){
        WorkMagger workByPage = workService.getWorkByPage(page, rows);
        return workByPage;
    }

    @RequestMapping("work/add_judge")
    @ResponseBody
    public String add_judge(){
        return "";
    }

    @RequestMapping("work/add")
    public ModelAndView add(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/work_add.jsp");
        return modelAndView;
    }


    @RequestMapping("work/insert")
    @ResponseBody
    public ResponseVo insert(Work work){
        int status = workService.insert(work);
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

    @RequestMapping("work/edit_judge")
    @ResponseBody
    public String edit_judge(){
        return "{}";
    }

    @RequestMapping("work/edit")
    public ModelAndView edit(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/work_edit.jsp");
        return modelAndView;
    }

    @RequestMapping("work/update_all")
    @ResponseBody
    public ResponseVo updata(Work work){
        int status = workService.updata(work);
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

    @RequestMapping("work/delete_judge")
    @ResponseBody
    public String delete_judge(){
        return "";
    }

    @RequestMapping("work/delete_batch")
    @ResponseBody
    public ResponseVo delete_batch(String[] ids){
        int status = workService.delete(ids);
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

    @RequestMapping("work/search_work_by_workId")
    @ResponseBody
    public WorkMagger search_work_by_workId(String searchValue, String page, String rows){
        WorkMagger workMagger = workService.searchById(searchValue, page, rows);
        return workMagger;
    }

    @RequestMapping("work/search_work_by_workProduct")
    @ResponseBody
    public WorkMagger search_work_by_workProduct(String searchValue, String page, String rows){
        WorkMagger workMagger = workService.searchByProduct(searchValue, page, rows);
        return workMagger;
    }

    @RequestMapping("work/search_work_by_workDevice")
    @ResponseBody
    public WorkMagger search_work_by_workDevice(String searchValue, String page, String rows){
        WorkMagger workMagger = workService.searchByDevice(searchValue, page, rows);
        return workMagger;
    }

    @RequestMapping("work/search_work_by_workProcess")
    @ResponseBody
    public WorkMagger search_work_by_workProcess(String searchValue, String page, String rows){
        WorkMagger workMagger = workService.searchByProcess(searchValue, page, rows);
        return workMagger;
    }

    @RequestMapping("work/get_data")
    @ResponseBody
    public List<Work> get_data(){
        List<Work> allWorks = workService.getAllWorks();
        return allWorks;
    }

}
