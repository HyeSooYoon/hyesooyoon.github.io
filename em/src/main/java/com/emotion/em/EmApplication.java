package com.emotion.em;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy 
public class EmApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmApplication.class, args);
	}

}
