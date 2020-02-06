package com.bohai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TargetController {

    @RequestMapping("/target")
    public ModelAndView show(){

        System.out.println("目标资源执行....");
        ModelAndView view = new ModelAndView();
        view.addObject("username","bohai");
        view.setViewName("success");
        return view;
    }

}
