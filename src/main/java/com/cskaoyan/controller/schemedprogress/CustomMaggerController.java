package com.cskaoyan.controller.schemedprogress;

import com.cskaoyan.bean.Custom;
import com.cskaoyan.bean.schemedprogress.CustomMagger;
import com.cskaoyan.service.schemedprogress.CustomMaggerService;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("custom")
public class CustomMaggerController {

    @Autowired
    CustomMaggerService customMaggerService;

    @Autowired
    HttpSession session;

    @RequestMapping("list")
    @ResponseBody
    public CustomMagger getCustomList(String page, String rows){
        CustomMagger customMagger = customMaggerService.selectOrdersByPage(page, rows);
        return customMagger;
    }

    @RequestMapping("find")
    public ModelAndView getList(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/custom_list.jsp");
        String[] sysPermissionList = {"custom:add","custom:edit","custom:delete"};
        session.setAttribute("sysPermissionList",sysPermissionList);
        return modelAndView;
    }

    @RequestMapping("get/{cid}")
    @ResponseBody
    public Custom getCustomById(@PathVariable("cid") String cid){
        List<Custom> customs = customMaggerService.selectOrdersById(cid);
        Custom custom = customs.get(0);

        return custom;
    }

    @RequestMapping("add_judge")
    @ResponseBody
    public String add_judge(){
        return "";
    }

    @RequestMapping("add")
    public ModelAndView add(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/custom_add.jsp");
        return modelAndView;
    }

    @RequestMapping("insert")
    @ResponseBody
    public ResponseVo insert(Custom custom){
        int status = customMaggerService.insertCustom(custom);
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
        modelAndView.setViewName("/WEB-INF/jsp/custom_edit.jsp");
        return modelAndView;
    }

    @RequestMapping("update_all")
    @ResponseBody
    public ResponseVo update_all(Custom custom){
        int status = customMaggerService.upddateCustom(custom);
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
        int status = customMaggerService.deleteCustom(ids);
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

    @RequestMapping("search_custom_by_customId")
    @ResponseBody
    public List<Custom> search_custom_by_customId(String searchValue, String page, String rows){
        List<Custom> customs = customMaggerService.search_custom_by_customId(searchValue, page, rows);
        return customs;
    }

    @RequestMapping("search_custom_by_customName")
    @ResponseBody
    public List<Custom> search_custom_by_customName(String searchValue, String page, String rows){
        List<Custom> customs = customMaggerService.search_custom_by_customName(searchValue, page, rows);
        return customs;
    }
}
