package com.sprayou.spray.controller;

import java.util.HashMap;
import java.util.Map;

import com.sprayou.spray.dto.VendorDto;
import com.sprayou.spray.model.ResponseBase;
import com.sprayou.spray.service.VendorService;
import com.sprayou.spray.util.ResponseHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class VendorController {
     
    @Autowired
    private VendorService vendorService;
    
    @RequestMapping(value = "/vendor", method = RequestMethod.GET)
    public ResponseEntity<ResponseBase> selectUserInfo() {

        log.info("네이버 API 연동");

        try {
            Map<String, String> map = new HashMap<>();
            // ResponseEntity dto = vendorService.findToShopAll();
            vendorService.findToShopAll();

            // dto.builder().name(dto.getName())
            //         .eaddr(dto.getEaddr())
            //         .tel(dto.getTel())
            //         .build();

            // map.put("name"         , dto.getName());
            // map.put("eaddr"        , dto.getEaddr());
            // map.put("tel"          , dto.getTel());

            return ResponseHelper.success(map);
        } catch (Exception e) {
            return ResponseHelper.fail(e);
        }
    }
}
