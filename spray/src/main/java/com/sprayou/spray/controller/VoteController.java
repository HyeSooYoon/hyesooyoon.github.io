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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class VoteController {

    @Autowired
    private BoardService boardService;
  
    @RequestMapping(value="/spray/vote/voteFront", method = RequestMethod.GET)
    public ModelAndView voteChartView(ModelAndView mv) {
        log.info("차트 보기");
        mv.setViewName("/spray/vote/voteFront");
        return mv;
    }  


}
