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
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping(value="/spray/board/boardFrontMenu", method = RequestMethod.GET)
    public ModelAndView boardList(ModelAndView mv) {
        log.info("게시판 목록 조회");
        mv.addObject("boardList", boardService.list());
        return mv;
    }

    @RequestMapping(value="/spray/board/boardWrite", method = RequestMethod.GET)
    public ModelAndView boardWrite(ModelAndView mv) {
        log.info("게시판 작성");
        return mv;
    }

    @RequestMapping(value="/spray/board/boardContent/{num}", method = RequestMethod.GET)
    public ModelAndView board(ModelAndView mv, @PathVariable String num) {
        log.info("게시판 상세 내용");
        mv.addObject("boardDetail", boardService.detail(num));
        mv.setViewName("/spray/board/boardContent");
        return mv;
    }

    @RequestMapping(value="/viewCount", method = RequestMethod.GET)
    public ResponseEntity<ResponseBase> boardViewCount(@RequestBody BoardDto boardDto) {
        log.info("조회수 업데이트");
        try {
            System.out.println("boardDto : " + boardDto);
            int result = boardService.viewCount(boardDto);

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

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public ResponseEntity<ResponseBase> boardSave(@RequestBody BoardDto boardDto) {
        try {
            System.out.println("boardDto : " + boardDto);
            int result = boardService.save(boardDto);

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



}
