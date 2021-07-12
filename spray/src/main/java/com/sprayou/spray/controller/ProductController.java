package com.sprayou.spray.controller;

import com.sprayou.spray.dto.CosmeticsDto;
import com.sprayou.spray.dto.VendorDto;
import com.sprayou.spray.model.ResponseBase;
import com.sprayou.spray.model.ResultCode;
import com.sprayou.spray.service.BoardService;
import com.sprayou.spray.util.ResponseHelper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.ResponseEntity;

@Slf4j
@Controller
public class ProductController {

    @Autowired
    private BoardService boardService;

    @RequestMapping(value = "/spray/product/productDesc/{productCd}", method = RequestMethod.GET)
    public ModelAndView productDetail(@PathVariable String productCd) {

        log.info("제품 상세 페이지 접속");
        ModelAndView mv = new ModelAndView();

        mv.addObject("productCd", productCd);
        mv.setViewName("/spray/product/productDesc");

        return mv;
    }

     
  

}

