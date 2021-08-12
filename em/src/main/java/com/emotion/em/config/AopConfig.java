package com.emotion.em.config;

import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect; 
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import lombok.extern.slf4j.Slf4j;
import com.google.common.base.Joiner;

@Slf4j
@Aspect
@Configuration
public class AopConfig {

    private String paramMapToString(Map<String, String[]> paramMap) {
        return paramMap.entrySet().stream()
            .map(entry -> String.format("%s -> (%s)",
                entry.getKey(), Joiner.on(",").join(entry.getValue())))
            .collect(Collectors.joining(", "));
      }
  
    @Pointcut("within(com.emotion.em..*)") // 3
    public void onRequest() {}
  
    @Around("com.emotion.em.config.AopConfig.onRequest()") // 4
    public Object doLogging(ProceedingJoinPoint pjp) throws Throwable {
      HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest(); // 5
  
      Map<String, String[]> paramMap = request.getParameterMap();
      String params = "";
      if (paramMap.isEmpty() == false) {
        params = " [" + paramMapToString(paramMap) + "]";
      }
  
      long start = System.currentTimeMillis();

      try {
        return pjp.proceed(pjp.getArgs()); // 6

      } finally {
        long end = System.currentTimeMillis();
        log.info("◀◀◀◀◀◀ Request: [{}{}{}][{}] ({}ms)"
            , request.getMethod()
            , request.getRequestURI()
            , params
            , request.getRemoteHost()
            , end - start);
      }
    }

    
}
