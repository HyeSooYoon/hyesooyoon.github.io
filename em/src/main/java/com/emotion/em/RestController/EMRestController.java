package com.emotion.em.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@RestController
public class EMRestController {

    @GetMapping(value="/test")
    public String EMMain() {
        return "hello world";
    }

    @PostMapping("/searchTwitchIdVD")
    public Mono<VdTwitchDto.Res> searchTwitchIdVD(@RequestBody VdTwitchDto.Req req) throws UnsupportedEncodingException { 
      
        return webClient
                .mutate()  
                .defaultHeaders(httpHeaders -> {
                    httpHeaders.add("client-id", "nl6rjwfpih6j5qgpidrj4u6zv19qn6");
                    httpHeaders.add("Authorization", "Bearer ryhqwr9kdozqucy3761e8gvbxruvsh");
                  })
                .baseUrl("https://api.twitch.tv")                
                .build()  
                .get()
                .uri("/helix/search/channels?query={query}", req.getQuery())
                .retrieve()
                .bodyToMono(VdTwitchDto.Res.class); 
    }
 
}
