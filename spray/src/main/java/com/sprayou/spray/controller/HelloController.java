package com.sprayou.spray.controller;

import java.util.List;

import com.sprayou.spray.dao.HelloDao;
import com.sprayou.spray.dto.HelloDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @Autowired
	private HelloDao helloDao;

	@RequestMapping("/add")
	public HelloDto add(HelloDto hello) {

		HelloDto helloData = helloDao.save(hello);

		return helloData;
	}

	@RequestMapping("/list")
	public List<HelloDto> list(Model model) {

		List<HelloDto> helloList = helloDao.findAll();

		return helloList;
	}

	@RequestMapping("/")
	public String index() {
		return "helloworld!";
	}

	// 이메일 인증 테스트
	@GetMapping("/email")
	public String email() {
		return "helloworld!";
	}








}
