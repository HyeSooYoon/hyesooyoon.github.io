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

    // ?????? ??????
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

    // ???????????? ???????????? ?????? ?????? ??????. ??????????????? ??????????????? ?????? ??????.
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
 
    // ????????? ??????
    @PostMapping("/sendMail")
    @ResponseBody  
	public boolean SendMail(@RequestBody HashMap<String, Object> map, HttpServletRequest request) {
		
        Random random = new Random(); 
		String key="";  //???????????? 
        String mailadds = map.get("mailadds").toString();

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(mailadds); //?????????????????? ?????? ????????? ?????? ????????? ????????? ?????? 
		
        //?????? ?????? ?????? ??????
		for(int i =0; i<3;i++) {
			int index=random.nextInt(25) + 65; 
			key += (char)index;
		}
		
        int numIndex = random.nextInt(9999) + 1000; 
		key += numIndex;

        request.getSession().setAttribute("key", key);

        return EmailSenderService.SendMessage("google?????? ?????????(????????? ????????????)", "google?????? ????????????(????????? ????????????)", mailadds, "???????????? ????????? ?????? ?????? ??????", "?????? ?????? : "+key);
	}

    // ????????? ?????? 
    @PostMapping("/certMail")
    @ResponseBody  
	public boolean CertMail(@RequestBody HashMap<String, Object> map, HttpServletRequest request) {

        // ?????????
        String key = (String) request.getSession().getAttribute("key");
 
        return request.getSession().getAttribute("key").equals(map.get("certKey").toString());
	}
}
