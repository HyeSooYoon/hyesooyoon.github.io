package com.emotion.em.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
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
        registry.addViewController("/").setViewName("forward:/login");  
        registry.addViewController("/login").setViewName("login"); 
        registry.addViewController("/em").setViewName("em"); 
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);  
    } 
        
    @Override 
    public void addResourceHandlers(ResourceHandlerRegistry registry) { 
        registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS); 
    }



    
}
