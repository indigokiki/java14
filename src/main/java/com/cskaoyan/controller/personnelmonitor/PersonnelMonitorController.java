package com.cskaoyan.controller.personnelmonitor;

import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.Employee;
import com.cskaoyan.bean.Employee_p;
import com.cskaoyan.service.personnelmonitor.EmployeeService;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.cskaoyan.bean.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//员工管理
@Controller
@ResponseBody
public class PersonnelMonitorController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("employee/find")
    public ModelAndView employeefind(ModelAndView modelAndView, HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        List<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("employee:add");
        sysPermissionList.add("employee:edit");
        sysPermissionList.add("employee:delete");
        session.setAttribute("sysPermissionList", sysPermissionList);
        modelAndView.setViewName("/WEB-INF/jsp/employee_list.jsp");
        return modelAndView;
    }

    @RequestMapping("employee/list")
    public Page employeepage(int page, int rows) {
        return employeeService.getEmployeePage(page, rows);
    }

    @RequestMapping("employee/add_judge")
    public String employeeadd() {
        return "{}";
    }

    @RequestMapping("employee/delete_judge")
    public String employeedelete() {
        return "{}";
    }

    @RequestMapping("employee/edit_judge")
    public String employeeedit() {
        return "{}";
    }

    @RequestMapping("employee/add")
    public ModelAndView employeeadd(ModelAndView modelAndView) {
        modelAndView.setViewName("/WEB-INF/jsp/employee_add.jsp");
        return modelAndView;
    }

    @RequestMapping("employee/edit")
    public ModelAndView employeeedit(ModelAndView modelAndView) {
        modelAndView.setViewName("/WEB-INF/jsp/employee_edit.jsp");
        return modelAndView;
    }

    @RequestMapping("employee/insert")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ResponseVo employeeinsert(Employee employee) {
        int status = employeeService.addEmployee(employee);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (status == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        } else {
            responseVo.setStatus(0);
            responseVo.setMsg("操作失败！请联系管理员！");
        }
        return responseVo;
    }

    @RequestMapping("employee/update_all")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ResponseVo employeeupdata(Employee employee) {
        int status = employeeService.updataEmployee(employee);//service层加方法
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (status == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        } else {
            responseVo.setStatus(0);
            responseVo.setMsg("操作失败！请联系管理员！");
        }
        return responseVo;
    }

    @RequestMapping("employee/delete_batch")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ResponseVo employeedelete(String[] ids) {
        int status = employeeService.deleteEmployee(ids);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (status == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        } else {
            responseVo.setStatus(0);
            responseVo.setMsg("操作失败！请联系管理员！");
        }
        return responseVo;
    }

    @RequestMapping("employee/search_employee_by_employeeId")
    public Page searchByEmployeeId(String searchValue, int page, int rows) {
        return employeeService.selectEmployeeByEmployeeId(searchValue, page, rows);
    }
    @RequestMapping("employee/search_employee_by_employeeName")
    public Page searchByEmployeeName(String searchValue, int page, int rows) {
        return employeeService.selectEmployeeByEmployeeName(searchValue, page, rows);
    }
    @RequestMapping("employee/search_employee_by_departmentName")
    public Page searchByDepartmentName(String searchValue, int page, int rows) {
        return employeeService.selectEmployeeByDepartmentName(searchValue, page, rows);
    }
}

