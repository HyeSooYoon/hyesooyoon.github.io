package com.surfingvd.vd.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VDApiController {
    
    @RequestMapping("/test")
	public String test() {

		return "test";
	}
}
