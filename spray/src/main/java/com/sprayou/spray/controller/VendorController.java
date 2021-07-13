package com.sprayou.spray.controller;

import java.util.HashMap;
import java.util.Map;
import com.sprayou.spray.model.ResponseBase;
import com.sprayou.spray.service.VendorService;
import com.sprayou.spray.util.ResponseHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class VendorController {
     
    @Autowired
    private VendorService vendorService;
    
    @RequestMapping(value = "/vendor/{productCd}", method = RequestMethod.GET)
    public ResponseEntity<ResponseBase> selectUserInfo(@PathVariable String productCd) {

        log.info("네이버 API 연동");

        try {
            Map<String, String> map = vendorService.findToShopAll(productCd); 
            return ResponseHelper.success(map);
        } catch (Exception e) {
            return ResponseHelper.fail(e);
        }
    }
}
