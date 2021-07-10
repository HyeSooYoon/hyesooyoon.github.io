package com.sprayou.spray.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthorityDto implements UserDetails {

    private Collection<? extends GrantedAuthority> authorities;
    private String name;  // principal - biz name : email
    private String tel;  // credential
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // ROLE
        return authorities;
    }

    @Override
    public String getPassword() {
        return tel;
    }

    @Override
    public String getUsername() {
        return name;
    }


    // -------------- 계정에 대한 디테일한 설정 -----------------
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    // -----------------------------------------------
 
    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public void setUsername(String name) {
        this.name = name;
    }

    public void setPassword(String tel) {
        this.tel = tel;
    }

}