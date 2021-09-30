package com.emotion.em.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @Configuration
@ComponentScan
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = { 
            "classpath:/static/", "classpath:/public/",
            "classpath:/", "classpath:/resources/", "classpath:/META-INF/resources/",
            "classpath:/META-INF/resources/webjars/" 
        };

    @Override 
    public void addViewControllers(ViewControllerRegistry registry) { 
        // registry.addViewController( "/" ).setViewName( "forward:/index" ); // /에 해당하는 url mapping을 /common/test로 forward한다. 
        // registry.setOrder(Ordered.HIGHEST_PRECEDENCE); // 우선순위를 가장 높게 잡는다. 

        registry.addViewController("/login").setViewName("login");



    } 
        
    // @Override 
    // public void addResourceHandlers(ResourceHandlerRegistry registry) { 
    //     registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS); 
    // }



    
}
