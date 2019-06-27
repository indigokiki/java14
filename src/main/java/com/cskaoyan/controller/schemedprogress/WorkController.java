package com.cskaoyan.controller.schemedprogress;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("work")
public class WorkController {

    @RequestMapping("find")
    public ModelAndView find(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/work_list.jsp");
        return modelAndView;
    }


}
