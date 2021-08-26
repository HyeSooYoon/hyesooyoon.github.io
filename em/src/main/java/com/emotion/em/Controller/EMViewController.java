package com.emotion.em.Controller;

import java.util.List;

import com.emotion.em.Entity.TbDiaryTitle;
import com.emotion.em.service.EmDiarySaveService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.servlet.ModelAndView; 
 
@Controller
public class EMViewController {

    @Autowired
    EmDiarySaveService emDiarySaveService; 
    
    @GetMapping(value="/em")
    public ModelAndView EMMain() {
        ModelAndView mv = new ModelAndView();

        List<TbDiaryTitle> tbDiaryTitle = emDiarySaveService.selectTitleAll();
        mv.addObject("tbdiarytitle", tbDiaryTitle);        
        mv.setViewName("/em");
        return mv;
    }
 
}
