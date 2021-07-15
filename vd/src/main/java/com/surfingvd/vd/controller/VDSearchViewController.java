package com.surfingvd.vd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class VDSearchViewController {

    @RequestMapping(value="/surfVideo")
    public ModelAndView surffing() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/surfVideo");
        return mv;
    }
    
}
