package com.cskaoyan.controller.schemedprogress;


import com.cskaoyan.bean.Task;
import com.cskaoyan.bean.schemedprogress.TaskMagger;
import com.cskaoyan.service.schemedprogress.TaskService;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("task")
public class TaskController {

    @Autowired
    HttpSession session;

    @Autowired
    TaskService taskService;

    @RequestMapping("find")
    public ModelAndView find(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/task_list.jsp");
        String[] sysPermissionList = {"task:add","task:edit","task:delete"};
        session.setAttribute("sysPermissionList",sysPermissionList);
        return modelAndView;
    }

    @RequestMapping("list")
    @ResponseBody
    public TaskMagger getTaskMaggerByPage(String page, String rows){
        TaskMagger allTask = taskService.getTaskByPage(page, rows);
        return allTask;
    }

    @RequestMapping("add_judge")
    @ResponseBody
    public String add_judge(){
        return "";
    }

    @RequestMapping("add")
    public ModelAndView add(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/task_add.jsp");
        return modelAndView;
    }

    @RequestMapping("insert")
    @ResponseBody
    public ResponseVo insert(Task task){
        int status = taskService.insert(task);
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

    @RequestMapping("edit_judge")
    @ResponseBody
    public String edit_judge(){
        return "{}";
    }

    @RequestMapping("edit")
    public ModelAndView edit(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/task_edit.jsp");
        return modelAndView;
    }

    @RequestMapping("update_all")
    @ResponseBody
    public ResponseVo update_all(Task task){
        int status = taskService.update(task);
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

    @RequestMapping("delete_judge")
    @ResponseBody
    public String delete_judge(){
        return "";
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public ResponseVo delete_batch(String[] ids){
        int status = taskService.delete(ids);
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

    @RequestMapping("search_task_by_taskId")
    @ResponseBody
    public TaskMagger search_task_by_taskId(String searchValue, String page, String rows ){
        TaskMagger taskMagger = taskService.search_task_by_taskId(searchValue, page, rows);
        return taskMagger;

    }

    @RequestMapping("search_task_by_taskWorkId")
    @ResponseBody
    public TaskMagger search_task_by_taskWorkId(String searchValue, String page, String rows ){
        TaskMagger taskMagger = taskService.search_task_by_taskWorkId(searchValue, page, rows);
        return taskMagger;

    }

    @RequestMapping("search_task_by_taskManufactureSn")
    @ResponseBody
    public TaskMagger search_task_by_taskManufactureSn(String searchValue, String page, String rows ){
        TaskMagger taskMagger = taskService.search_task_by_taskManufactureSn(searchValue, page, rows);
        return taskMagger;

    }
}
