package com.sprayou.spray.service;

import com.sprayou.spray.dao.UserDao;
import com.sprayou.spray.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDto selectUserInfo(String tel) {
        return userDao.selectUser(tel);
    }

    @Override
    public List<UserDto> list() {
        return userDao.selectUsers();
    }

    @Override
    public int insert(UserDto userDto) {
        return userDao.insertUser(userDto);
    }

    @Override
    public int insertUserName(String no, String name) {
        return userDao.insertUserName(no, name);
    }

    @Override
    public int delete(String name) {
        return userDao.delete(name);
    }

    @Override
    public int update(UserDto dto) {
        return userDao.update(dto);
    }
 
}
