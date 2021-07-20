package com.surfingvd.vd.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient; 
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono; 

@RestController
@Slf4j
public class WebClientController {
 
    @Autowired
    private WebClient webClient; 
    
    @GetMapping("/test1")
    public Mono<String> doTest1() {
        return webClient.get()
                .uri("/webclient/test-builder")
                .retrieve()
                .bodyToMono(String.class);
    }
    
    @GetMapping("/test2")
    public Mono<String> doTest2() {
        return webClient
                .mutate() 
                .baseUrl("http://localhost:5011")
                .build()
                .get()
                .uri("/webclient/test-mutate")
                .retrieve()
                .bodyToMono(String.class);
    }
    
}
