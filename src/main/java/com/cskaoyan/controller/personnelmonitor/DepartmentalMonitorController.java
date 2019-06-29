package com.cskaoyan.controller.personnelmonitor;

import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.Page;
import com.cskaoyan.service.personnelmonitor.DepartmentService;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sun.security.util.DerEncoder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

//部门管理
@Controller
@ResponseBody
public class DepartmentalMonitorController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("department/find")
    public ModelAndView departermentfind(ModelAndView modelAndView,HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        List<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("department:add");
        sysPermissionList.add("department:edit");
        sysPermissionList.add("department:delete");
        session.setAttribute("sysPermissionList",sysPermissionList);
        modelAndView.setViewName("/WEB-INF/jsp/department_list.jsp");
        return modelAndView;
    }

    @RequestMapping("department/list")
    public Page departmentage(int page, int rows){
        return departmentService.getDepartmentPage(page,rows);
    }

    @RequestMapping("department/add_judge")
    public String departmentadd(){
        return "{}";
    }

    @RequestMapping("department/delete_judge")
    public String departmentdelete(){
        return "{}";
    }

    @RequestMapping("department/edit_judge")
    public String departmentedit(){
        return "{}";
    }

   @RequestMapping("department/add")
    public ModelAndView departermentadd(ModelAndView modelAndView) {
        modelAndView.setViewName("/WEB-INF/jsp/department_add.jsp");
        return modelAndView;
    }
    @RequestMapping("department/edit")
    public ModelAndView departermentedit(ModelAndView modelAndView) {
        modelAndView.setViewName("/WEB-INF/jsp/department_edit.jsp");
        return modelAndView;
    }

    @RequestMapping("department/insert")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ResponseVo departmentinsert(Department department){
        int status = departmentService.addDepartment(department);//service层加方法
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

    @RequestMapping("department/update_all")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ResponseVo departmentupdata(Department department){
        int status = departmentService.updataDepartment(department);//service层加方法
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

    @RequestMapping("department/delete_batch")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ResponseVo departmentdelete(String[] ids){
        int status = departmentService.deleteDepartment(ids);
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
    @RequestMapping("department/search_department_by_departmentId")
    public Page searchByEmployeeId(String searchValue, int page, int rows) {
        System.out.println();
        return departmentService.selectDepratmentByDepartmentId(searchValue, page, rows);
    }
    @RequestMapping("department/search_department_by_departmentName")
    public Page searchByEmployeeName(String searchValue, int page, int rows) {
        return departmentService.selectDepratmentByDepartmentName(searchValue, page, rows);
    }
}
