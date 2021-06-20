package com.sprayou.spray.mapper;

import com.sprayou.spray.dto.UserDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    UserDto selectUserInfo(String no);
    List<UserDto> list();
    int insert(UserDto userDto);
    int delete(String name);
    int update(UserDto dto);
    int insertUserName(@Param("no") String no, @Param("name") String name);
}