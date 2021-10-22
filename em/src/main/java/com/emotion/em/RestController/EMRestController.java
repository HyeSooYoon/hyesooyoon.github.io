package com.emotion.em.RestController;

import java.util.List;

import javax.validation.Valid; 
import com.emotion.em.Dto.DiaryContents;
import com.emotion.em.Entity.TbDiaryTitle;
import com.emotion.em.model.response.CommonResult;
import com.emotion.em.service.EmDiarySaveService;
import com.emotion.em.service.ResponseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;  

@RestController
public class EMRestController {

    @Autowired
    private final EmDiarySaveService emDiarySaveService; 

    @Autowired
    private final ResponseService responseService;
    StringBuilder stringBuilder;
     
    public EMRestController(EmDiarySaveService emDiarySaveService, ResponseService responseService) {
        this.emDiarySaveService = emDiarySaveService;
        this.responseService = responseService;
    }

    @PostMapping("/add")
    public DiaryContents DiaryContentsSave(@RequestBody @Valid DiaryContents req, BindingResult bindingResult) { 
        
        if (bindingResult.hasErrors()) {            
            stringBuilder = new StringBuilder();

            for (FieldError fieldError : bindingResult.getFieldErrors()) { 
                stringBuilder.append(fieldError.getField() + " " + fieldError.getDefaultMessage()); 
            }

            throw new RuntimeException(stringBuilder.toString());
        } 
        
        return emDiarySaveService.createDiary(req);
    }

    @GetMapping("/list/{uuid}")
    public DiaryContents DiaryContentsList(@PathVariable String uuid) { 
        return emDiarySaveService.selectDiary(uuid); 
    } 
  
    @GetMapping("/list")
    public List<TbDiaryTitle> DiaryTitleAllList() { 
        return emDiarySaveService.selectTitleAll(); 
    }
 
    @GetMapping("/listbyemcd/{emotion_cd}")
    public List<TbDiaryTitle> DiaryTitleByEmotionCode(@PathVariable String emotion_cd) {         
        return emDiarySaveService.selectTitleByEmotionCode(emotion_cd); 
    }

   
 
}
