package com.cskaoyan.controller.schemedprogress;

import com.cskaoyan.bean.Manufacture;
import com.cskaoyan.bean.schemedprogress.ManufactureMagger;
import com.cskaoyan.bean.schemedprogress.ManufactureRow;
import com.cskaoyan.service.schemedprogress.ManufactureService;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ManufactureController {

    @Autowired
    ManufactureService manufactureService;

    @Autowired
    HttpSession session;

    @RequestMapping("manufacture/find")
    public ModelAndView find(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/manufacture_list.jsp");
        String[] sysPermissionList = {"manufacture:add","manufacture:edit","manufacture:delete"};
        session.setAttribute("sysPermissionList",sysPermissionList);
        return modelAndView;
    }

    @RequestMapping("manufacture/list")
    @ResponseBody
    public ManufactureMagger getManufactureMaggerByPage(String page, String rows){
        ManufactureMagger manufactureByPage = manufactureService.getManufactureByPage(page, rows);
        return manufactureByPage;
    }

    @RequestMapping("manufacture/add_judge")
    @ResponseBody
    public String add_judge(){
        return "";
    }

    @RequestMapping("manufacture/add")
    public ModelAndView add(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/manufacture_add.jsp");
        return modelAndView;
    }

    @RequestMapping("manufacture/insert")
    @ResponseBody
    public ResponseVo insert(Manufacture manufacture){
        int status = manufactureService.insert(manufacture);
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

    @RequestMapping("manufacture/edit_judge")
    @ResponseBody
    public String edit_judge(){
        return "";
    }

    @RequestMapping("manufacture/edit")
    public ModelAndView edit(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/manufacture_edit.jsp");
        return modelAndView;
    }

    @RequestMapping("manufacture/update_all")
    @ResponseBody
    public ResponseVo update(Manufacture manufacture){
        int status = manufactureService.update(manufacture);
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

    @RequestMapping("manufacture/delete_judge")
    @ResponseBody
    public String delete_judge(){
        return "";
    }

    @RequestMapping("manufacture/delete_batch")
    @ResponseBody
    public ResponseVo delete_batch(String[] ids){
        int status = manufactureService.delete(ids);
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

    @RequestMapping("manufacture/search_manufacture_by_manufactureSn")
    @ResponseBody
    public ManufactureMagger search_custom_by_customId(String searchValue, String page, String rows){
        ManufactureMagger manufactureMagger = manufactureService.search_manufacture_by_manufactureSn(searchValue, page, rows);
        return manufactureMagger;
    }

    @RequestMapping("manufacture/search_manufacture_by_manufactureOrderId")
    @ResponseBody
    public ManufactureMagger search_manufacture_by_manufactureOrderId(String searchValue, String page, String rows){
        ManufactureMagger manufactureMagger = manufactureService.search_manufacture_by_manufactureOrderId(searchValue, page, rows);
        return manufactureMagger;
    }

    @RequestMapping("manufacture/search_manufacture_by_manufactureTechnologyName")
    @ResponseBody
    public ManufactureMagger search_manufacture_by_manufactureTechnologyName(String searchValue, String page, String rows){
        ManufactureMagger manufactureMagger = manufactureService.search_manufacture_by_manufactureTechnologyName(searchValue, page, rows);
        return manufactureMagger;
    }

    @RequestMapping("manufacture/get_data")
    @ResponseBody
    public List<Manufacture> get_data(){
        List<Manufacture> allManufactures = manufactureService.getAllManufactures();
        return allManufactures;
    }
}
