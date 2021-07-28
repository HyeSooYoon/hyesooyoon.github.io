package com.surfingvd.vd.apiController;
  
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.surfingvd.vd.dto.VdYoutubeDto;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
public class VDApiController { 
 
  @Autowired
  private WebClient webClient;  

  @PostMapping("/searchYoutubeVD")
    public Mono<String> searchYoutubeVD(@RequestBody VdYoutubeDto.Req req) throws UnsupportedEncodingException { 
      
        return webClient
                .mutate()  
                .baseUrl("https://www.googleapis.com")
                .build()  
                .get()
                .uri("/youtube/v3/search?part=snippet&q={q}&key={key}", req.getQ(), ")
                .retrieve()
                .bodyToMono(String.class); 
    }
    
}
