package com.surfingvd.vd.apiController;
  
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
public class VDApiController {

  @Autowired
    private WebClient webClient;  

  @GetMapping("/searchYoutubeVD")
    public Mono<String> searchYoutubeVD() {
        return webClient
                .mutate() 
                .baseUrl("http://localhost:8080")
                .build()
                .get()
                .uri("/webclient/test-mutate")
                .retrieve()
                .bodyToMono(String.class);
    }
    
}
