package com.emotion.em.RestController;

import com.emotion.em.Dto.*;
import com.emotion.em.service.*;
import org.springframework.web.bind.annotation. *;
@RestController public class UserInfoController {
    
    final UserInfoService userInfoService;

    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @PostMapping("/userinfo")
    public UserInfoDto createUserInfo(@RequestBody UserInfoDto userInfoDto) {
        return userInfoService.createUserInfo(userInfoDto);
    }

    @GetMapping("/userinfo/{name}")
    public UserInfoDto selectUserInfo(@PathVariable String name) {
        return userInfoService.selectUserInfo(name);
    }

    @PutMapping("/userinfo/{name}")
    public UserInfoDto updateUserInfo(@PathVariable String name,@RequestBody UserInfoDto userInfoDto) {
        return userInfoService.updateUserInfo(name, userInfoDto);
    }

    @DeleteMapping("/userinfo/{name}")
    public String deleteUserInfo(@PathVariable String name) {
        userInfoService.deleteUserInfo(name);
        return "deleted " + name;
    }
}

