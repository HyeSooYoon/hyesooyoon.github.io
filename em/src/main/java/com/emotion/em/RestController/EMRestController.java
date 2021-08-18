package com.emotion.em.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List; 
import javax.validation.Valid; 
import com.emotion.em.Dto.DiaryContents; 
import com.emotion.em.model.response.CommonResult;
import com.emotion.em.service.EmDiarySaveService;
import com.emotion.em.service.ResponseService; 
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RestController;  

@RestController
public class EMRestController {

    private final EmDiarySaveService emDiarySaveService; 
    private final ResponseService responseService;
    StringBuilder stringBuilder;
     
    public EMRestController(EmDiarySaveService emDiarySaveService, ResponseService responseService) {
        this.emDiarySaveService = emDiarySaveService;
        this.responseService = responseService;
    }

    @PostMapping("/add")
    public CommonResult DiaryContentsSave(@RequestBody @Valid DiaryContents.Req req, BindingResult bindingResult) { 
        
        if (bindingResult.hasErrors()) {            
            stringBuilder = new StringBuilder();

            for (FieldError fieldError : bindingResult.getFieldErrors()) { 
                stringBuilder.append(fieldError.getField() + " " + fieldError.getDefaultMessage()); 
            }

            throw new RuntimeException(stringBuilder.toString());
        } 
            
        emDiarySaveService.createDiary(req); 

        return responseService.getSuccessResult();
    }


   
 
}
