package com.sprayou.spray.controller;

import com.sprayou.spray.dto.UserDto;
import com.sprayou.spray.model.ResponseBase;
import com.sprayou.spray.model.ResultCode;
import com.sprayou.spray.service.UserService;
import com.sprayou.spray.util.ResponseHelper;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                    .det(dto.getDet())
                    .addr(dto.getAddr())
                    .tel(dto.getTel())
                    .authorityName(dto.getAuthorityName())
                    .build();

            map.put("name"         , dto.getName());
            map.put("det"          , dto.getDet());
            map.put("addr"         , dto.getAddr());
            map.put("authorityName", dto.getAuthorityName());
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
                object.put("det"          , element.getDet());
                object.put("addr"         , element.getAddr());
                object.put("authorityName", element.getAuthorityName());
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
}
