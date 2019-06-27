package com.cskaoyan.controller.schemedprogress;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TaskController {

    @RequestMapping("task/find")
    public ModelAndView find(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/task_list.jsp");
        return modelAndView;
    }
}
