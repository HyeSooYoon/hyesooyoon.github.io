package com.emotion.em.config;

import com.emotion.em.service.MemberService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    private MemberService memberService;
 
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**", "/h2_db/**");        
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()                
                .antMatchers("/em").authenticated()
                .antMatchers("/em/**").authenticated()
                .antMatchers("/h2_db/**").permitAll()
            .and() 
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/em")
                .failureUrl("/login?auth=fail")     // 로그인 실패시 redirect
                .defaultSuccessUrl("/em", true)
                .usernameParameter("username")
                .passwordParameter("password") 
                .permitAll()
            .and() // 로그아웃 설정
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .logoutSuccessUrl("/user/logout/result")
                .invalidateHttpSession(true)
            .and()
                .exceptionHandling().accessDeniedPage("/user/denied");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin") 
                // .password("{noop}" + passwordEncoder().encode("1234")) // 암호화 
                .password("{noop}1234") 
                .roles("USER"); 

        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
    }
    
   
}