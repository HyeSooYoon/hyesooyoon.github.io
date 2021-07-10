package com.sprayou.spray;

import javax.servlet.http.HttpSessionListener;

import com.sprayou.spray.util.SessionListener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SprayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprayApplication.class, args);
	}

	@Bean
    public HttpSessionListener httpSessionListener(){
    return new SessionListener();
 }

}
