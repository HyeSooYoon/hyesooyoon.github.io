package com.sprayou.spray.controller;

import com.sprayou.spray.dto.UserDto;
import com.sprayou.spray.model.ResponseBase;
import com.sprayou.spray.model.ResultCode;
import com.sprayou.spray.service.EmailSenderService;
import com.sprayou.spray.service.UserService;
import com.sprayou.spray.util.ResponseHelper;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/user/{tel}", method = RequestMethod.GET)
    public ResponseEntity<ResponseBase> selectUserInfo(@PathVariable String tel) {
        try {
            Map<String, String> map = new HashMap<>();
            UserDto dto = userService.selectUserInfo(tel);

            dto.builder().name(dto.getName())
                    .eaddr(dto.getEaddr())
                    .tel(dto.getTel())
                    .build();

            map.put("name"         , dto.getName());
            map.put("eaddr"         , dto.getEaddr());
            map.put("tel"          , dto.getTel());

            return ResponseHelper.success(map);

        } catch (MyBatisSystemException e) {

            System.out.println("error message : "  + e.getMessage());
            return ResponseHelper.fail(ResultCode.JDBC_CONNECTION);

        } catch (Exception e) {
            return ResponseHelper.fail(e);
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<ResponseBase> list() {
        try {
            List<Map<String, String>> list = new ArrayList<>();

            for (UserDto element : userService.list()) {

                Map<String, String> object = new HashMap<>();
                object.put("no"           , element.getNo());
                object.put("name"         , element.getName());
                object.put("eaddr"         , element.getEaddr());
                object.put("authorityName", "USER");
                object.put("tel"          , element.getTel());

                list.add(object);
            }

            return ResponseHelper.success(list);
        } catch (MyBatisSystemException e) {
            return ResponseHelper.fail(ResultCode.JDBC_CONNECTION);
        } catch (Exception e) {
            return ResponseHelper.fail(e);
        }
    }

    // 회원 가입
    @RequestMapping(value="/user", method= RequestMethod.POST)
    public ResponseEntity<ResponseBase> insert(@RequestBody UserDto userDto) {
        try {
            System.out.println("userDto : " + userDto);
            int result = userService.insert(userDto);

            if (result == 1) {
                return ResponseHelper.success();
            } else {
                return ResponseHelper.fail(ResultCode.DB_FAIL);
            }
        } catch (MyBatisSystemException e) {
            return ResponseHelper.fail(e);
        } catch (Exception e) {
            return ResponseHelper.fail(e);
        }
    }

    // 파라미터 지정하여 회원 정보 저장. 파라미터는 쿼리스트링 으로 전달.
    @RequestMapping(value="/userName", method= RequestMethod.POST)
    public ResponseEntity<ResponseBase> insertUserName(String no, String name) {
        try {
            int result = userService.insertUserName(no, name);

            if (result == 1) {
                return ResponseHelper.success();
            } else {
                return ResponseHelper.fail(ResultCode.DB_FAIL);
            }
        } catch (MyBatisSystemException e) {
            return ResponseHelper.fail(e);
        } catch (Exception e) {
            return ResponseHelper.fail(e);
        }
    }

    @RequestMapping(value="/user", method= RequestMethod.DELETE)
    public ResponseEntity<ResponseBase> delete(String name) {
        try {
            int result = userService.delete(name);

            if (result == 1) {
                return ResponseHelper.success();
            } else {
                return ResponseHelper.fail(ResultCode.DB_FAIL);
            }
        } catch (MyBatisSystemException e) {
            return ResponseHelper.fail(ResultCode.JDBC_CONNECTION);
        } catch (Exception e) {
            return ResponseHelper.fail(e);
        }
    }

    @RequestMapping(value="/user/{no}", method={RequestMethod.PUT, RequestMethod.PATCH})
    public ResponseEntity<ResponseBase> update(@PathVariable("no") final String no,
                                               @RequestBody final UserDto update) {
        try {
            update.setNo(no);

            int result = userService.update(update);
            if (result == 1) {
                return ResponseHelper.success();
            } else {
                return ResponseHelper.fail(ResultCode.DB_FAIL);
            }
        } catch (MyBatisSystemException e) {
            return ResponseHelper.fail(ResultCode.JDBC_CONNECTION);
        } catch (Exception e) {
            return ResponseHelper.fail(e);
        }
    }
 
    // 이메일 전송
    @PostMapping("/sendMail")
    @ResponseBody  
	public boolean SendMail(@RequestBody HashMap<String, Object> map, HttpServletRequest request) {
		
        Random random = new Random(); 
		String key="";  //인증번호 
        String mailadds = map.get("mailadds").toString();

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(mailadds); //스크립트에서 보낸 메일을 받을 사용자 이메일 주소 
		
        //입력 키를 위한 코드
		for(int i =0; i<3;i++) {
			int index=random.nextInt(25) + 65; 
			key += (char)index;
		}
		
        int numIndex = random.nextInt(9999) + 1000; 
		key += numIndex;

        request.getSession().setAttribute("key", key);

        return EmailSenderService.SendMessage("yhss1790", "gPtn1790!", mailadds, "인증번호 입력을 위한 메일 전송", "인증 번호 : "+key);
	}

    // 이메일 인증 
    @PostMapping("/certMail")
    @ResponseBody  
	public boolean CertMail(@RequestBody HashMap<String, Object> map, HttpServletRequest request) {

        String key = (String) request.getSession().getAttribute("key");
 
        return request.getSession().getAttribute("key").equals(map.get("certKey").toString());
	}
}
