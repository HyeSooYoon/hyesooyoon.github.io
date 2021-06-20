package com.sprayou.spray.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories; 
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
        private UserDetailsService userdetailsservice ;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/favicon.ico");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 1. ACL 설정
        http.authorizeRequests()
                .antMatchers("/spray/sprayMain/**").authenticated()
                .antMatchers("/spray/board/boardFrontMenu/**").authenticated()
//                .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                .anyRequest().permitAll();
//        http.csrf().disable();

        // 2. 로그인 설정
        http
                .formLogin()
                .loginPage("/spray/login/sprayLogin") 	            // 로그인 페이지 url
                .loginProcessingUrl("/spray/sprayMain")
                .failureUrl("/spray/login/sprayLogin?auth=fail")     // 로그인 실패시 redirect
                .defaultSuccessUrl("/spray/sprayMain", true)
                .usernameParameter("tel")
                .passwordParameter("tel");

        // 3. 로그아웃 설정
        http
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/spray/login/sprayLogin")
                .invalidateHttpSession(true);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userdetailsservice);
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }





}