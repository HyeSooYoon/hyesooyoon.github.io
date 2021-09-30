package com.emotion.em.Controller;

import com.emotion.em.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MemberController {

    private MemberService memberService; 

    // 회원가입 페이지
    // @GetMapping("/user/signup")
    // public String dispSignup() {
    //     return "/signup";
    // }

    // 회원가입 처리
    // @PostMapping("/user/signup")
    // public String execSignup(MemberDto memberDto) {
    //     memberService.joinUser(memberDto); 
    //     return "redirect:/user/login";
    // } 

    // 로그인 페이지 체크..
    // @GetMapping(value="/login")    
    // public ModelAndView login() {
    //     ModelAndView mv = new ModelAndView();
    //     mv.setViewName("/login");
    //     return mv;
    // } 

    // 로그인 결과 페이지
    @PostMapping(value="/em")
    public ModelAndView EMLogin() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/em");
        return mv;
    } 

    // 로그아웃 결과 페이지
    // @GetMapping("/user/logout/result")
    // public String dispLogout() {
    //     return "/logout";
    // }

    // // 접근 거부 페이지
    // @GetMapping("/user/denied")
    // public String dispDenied() {
    //     return "/denied";
    // }

    // // 내 정보 페이지
    // @GetMapping("/user/info")
    // public String dispMyInfo() {
    //     return "/myinfo";
    // }

    // 어드민 페이지
    // @GetMapping("/admin")
    // public String dispAdmin() {
    //     return "/admin";
    // }
}
