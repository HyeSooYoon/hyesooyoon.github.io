package com.sprayou.spray.dao;
import com.sprayou.spray.dto.UserDto;
import com.sprayou.spray.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private SqlSession sqlSession;

    public UserDto selectUser(final String tel) {
        return sqlSession
                .getMapper(UserMapper.class)
                .selectUserInfo(tel);
    }

    public List<UserDto> selectUsers() {
        return sqlSession
                .getMapper(UserMapper.class)
                .list();
    }

    public int insertUser(final UserDto userDto) {
        return sqlSession
                .getMapper(UserMapper.class)
                .insert(userDto);
    }

    public int insertUserName(final String no, String name) {
        return sqlSession
                .getMapper(UserMapper.class)
                .insertUserName(no, name);
    }


    public int delete(String name) {
        return sqlSession
                .getMapper(UserMapper.class)
                .delete(name);
    }

    public int update(UserDto dto) {
        return sqlSession
                .getMapper(UserMapper.class)
                .update(dto);
    }
}
