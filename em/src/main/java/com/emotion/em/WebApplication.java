package com.emotion.em;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.emotion.em.config.AopConfig;
import com.emotion.em.config.WebMvcConfig;

public class WebApplication implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        // EnableWebMvc 사용시 필수 
        applicationContext.setServletContext(servletContext);
        // WebConfig.class를 설정 클래스로 지정
        applicationContext.register(WebMvcConfig.class);
        applicationContext.refresh();

        // DispatcherServlet을 등록
        DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);
        ServletRegistration.Dynamic app = servletContext.addServlet("app", dispatcherServlet);
        app.addMapping("/app/*");
    }
}
