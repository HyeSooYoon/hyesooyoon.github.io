package com.sprayou.spray.service;

import com.sprayou.spray.dao.UserDao;
import com.sprayou.spray.dto.UserAuthorityDto;
import com.sprayou.spray.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String tel) throws UsernameNotFoundException {
        UserDto userDto = userDao.selectUser(tel);

        UserAuthorityDto userauthoritydto = new UserAuthorityDto();

        if(userDto.getNo().equals("OK"))
        {
            throw new UsernameNotFoundException(tel);
        }
        else
        {
            userauthoritydto.setUsername(userDto.getName());
            userauthoritydto.setPassword("{noop}" + userDto.getTel());

            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("USER"));
            userauthoritydto.setAuthorities(authorities);
        }

        return userauthoritydto; // 여기서 return된 UserDetails는 SecurityContext의 Authentication에 등록되어 인증 정보를 갖고 있는다.
    }
}