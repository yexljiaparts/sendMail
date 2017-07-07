package com.email.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/2/18.
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView view=new ModelAndView();
        view.setViewName("/index");
        return view;
    }

    @RequestMapping("/home")
    public ModelAndView home(){
        ModelAndView view=new ModelAndView();
        view.setViewName("/home");
        return view;
    }


    @RequestMapping("/pageone")
    public ModelAndView test(){
        ModelAndView view=new ModelAndView();
        view.setViewName("/pageOne");
        return view;
    }
}
