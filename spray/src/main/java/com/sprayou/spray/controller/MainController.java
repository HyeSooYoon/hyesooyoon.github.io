package com.sprayou.spray.controller;

import com.sprayou.spray.dto.BoardDto;
import com.sprayou.spray.dto.UserDto;
import com.sprayou.spray.model.ResponseBase;
import com.sprayou.spray.model.ResultCode;
import com.sprayou.spray.service.BoardService;
import com.sprayou.spray.util.ResponseHelper;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class MainController {

    @Autowired
    private BoardService boardService;

    @RequestMapping(value = "/spray/login/sprayLogin", method = RequestMethod.GET)
    public ModelAndView index(String auth) {

        log.info("메인 페이지 접속");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/spray/login/sprayLogin");
        mv.addObject("auth", auth);

        return mv;
    }

    @RequestMapping(value="/portfolioMain")
    public ModelAndView index_test(String auth) {
        log.info("프로필 페이지 접속");
        return new ModelAndView();
    }

    @RequestMapping(value="/json", produces = "application/json")
    @ResponseBody
    public Object json(){
        Map<String, String> m = new HashMap<>();
        m.put("test", "1234");
        return m;
    }

    // 로그인 결과 페이지
    @RequestMapping(value="/spray/sprayMain")
    public String dispLoginResult() {
        return "spray/sprayMain";
    }

    @RequestMapping(value = "/mboard", method = RequestMethod.GET)
    public ResponseEntity<ResponseBase> list(HttpServletRequest request) {
        try {
            List<Map<String, String>> list = new ArrayList<>();
            log.info("썸네일 목록 조회");

            for (BoardDto element : boardService.list(request.getParameter("type"))) {

                Map<String, String> object = new HashMap<>();
                object.put("no"           , element.getNo());
                object.put("title"        , element.getTitle());
                object.put("writer"       , element.getWriter());
                object.put("regdte"       , element.getRegdte());
                object.put("readcnt"      , element.getReadcnt());
                object.put("voteCnt"      , element.getVoteCnt());                
                object.put("boardType"    , element.getBoardType());                
                list.add(object);
            }

            return ResponseHelper.success(list);
        } catch (MyBatisSystemException e) {
            return ResponseHelper.fail(ResultCode.JDBC_CONNECTION);
        } catch (Exception e) {
            return ResponseHelper.fail(e);
        }
    }






}
