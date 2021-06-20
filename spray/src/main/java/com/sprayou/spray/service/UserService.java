package com.sprayou.spray.service;


import com.sprayou.spray.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto selectUserInfo(String tel);
    List<UserDto> list();
    int insert(UserDto name);
    int delete(String name);
    int update(UserDto dto);
    int insertUserName(String no, String name);
}
