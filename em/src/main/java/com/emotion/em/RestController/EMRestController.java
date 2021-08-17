package com.emotion.em.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.validation.Valid;

import com.emotion.em.Dto.DiaryContents;
import com.emotion.em.exception.AppError;
import com.emotion.em.exception.SampleException;
import com.emotion.em.model.response.CommonResult;
import com.emotion.em.service.EmDiarySaveService;
import com.emotion.em.service.ResponseService;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;  

@RestController
public class EMRestController {

    private EmDiarySaveService emDiarySaveService;
    private ResponseService responseService;
    
    @GetMapping(value="/test")
    public String EMMain() {
        return "hello world";
    }

    @PostMapping("/add")
    public CommonResult DiaryContentsSave(@RequestBody @Valid DiaryContents.Req req, BindingResult bindingResult) throws UnsupportedEncodingException { 
        
        if (bindingResult.hasErrors()) {
            List<ObjectError> errorList = bindingResult.getAllErrors();
            for (ObjectError error : errorList)
                System.out.println(error.getDefaultMessage());             
        }
        else
        {
            emDiarySaveService.createDiary(req);
        }            

        return responseService.getSuccessResult();
    }


    @ExceptionHandler(SampleException.class)
    public @ResponseBody AppError sampleError(SampleException e) {
        AppError appError = new AppError();
        appError.setMessage("");
        appError.setReason("");
        return appError;
    }
 
}
