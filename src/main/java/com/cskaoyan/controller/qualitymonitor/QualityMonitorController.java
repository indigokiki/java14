package com.cskaoyan.controller.qualitymonitor;

import com.cskaoyan.bean.*;
import com.cskaoyan.service.qualitymonitor.QualityMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@ResponseBody
public class QualityMonitorController {

    @Autowired
    QualityMonitorService qualityMonitorService;

    @RequestMapping("unqualify/find*")
    public ModelAndView unqualifyfind(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/unqualify_list.jsp");
        return modelAndView;
    }

    @RequestMapping("measure/find*")
    public ModelAndView measurefind(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/measurement_list.jsp");
        return modelAndView;
    }

    @RequestMapping("f_count_check/find*")
    public ModelAndView fcountcheckfind(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/f_count_check_list.jsp");
        return modelAndView;
    }

    @RequestMapping("p_measure_check/find*")
    public ModelAndView pmeasurecheckfind(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/p_measure_check_list.jsp");
        return modelAndView;
    }

    @RequestMapping("p_count_check/find*")
    public ModelAndView pcountcheckfind(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/p_count_check_list.jsp");
        return modelAndView;
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



    @RequestMapping("unqualify/list*")
    public Page unqualifypage(int page,int rows){
        return qualityMonitorService.getUnqualifyPage(page,rows);
    }

    @RequestMapping("measure/list*")
    public Page measurepage(int page,int rows) {
        return qualityMonitorService.getMeasurePage(page, rows);
    }

    @RequestMapping("f_count_check/list*")
    public Page fcountcheck(int page,int rows){
        return  qualityMonitorService.getFCountCheckPage(page,rows);
    }

    @RequestMapping("p_measure_check/list*")
    public Page pmeasurecheckpage(int page,int rows) {
        return qualityMonitorService.getPMeasureCheckPage(page, rows);
    }

    @RequestMapping("p_count_check/list")
    public Page pcountcheckpage(int page,int rows){
        return qualityMonitorService.getPCountCheckPage(page,rows);
    }

}
