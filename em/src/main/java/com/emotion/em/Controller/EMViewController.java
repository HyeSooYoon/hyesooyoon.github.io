package com.emotion.em.Controller;

import java.util.List;

import com.emotion.em.Entity.TbDiaryTitle;
import com.emotion.em.service.EmDiarySaveService;
import com.google.gson.Gson;

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

        // List<TbDiaryTitle> tbDiaryTitle = emDiarySaveService.selectTitleAll();

        // Gson gson = new Gson();
        // String jsonPlace = gson.toJson(tbDiaryTitle);   
        // System.out.print("jsonPlace: " + jsonPlace);

        // mv.addObject("tbdiarytitle", jsonPlace);        
        mv.setViewName("/em");
        return mv;
    }
 
}
