package com.emotion.em.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
 
@Controller
public class EMViewController {

    @GetMapping(value="/em")
    public ModelAndView EMMain() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/em");
        return mv;
    }
 
}
