package com.emotion.em;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy 
public class EmApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(EmApplication.class, args); 

	}

}
