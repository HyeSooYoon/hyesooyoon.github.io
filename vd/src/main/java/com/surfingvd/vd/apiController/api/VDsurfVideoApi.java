package com.surfingvd.vd.apiController.api;

import com.surfingvd.vd.dto.VdYoutubeDto;
import com.surfingvd.vd.util.ResponseBase;
import com.surfingvd.vd.util.ResponseHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class VDsurfVideoApi {

    private final String YOUTUBE_URI = "https://www.googleapis.com/youtube/v3/search?part=snippet";

    // RestTemplate 예제
    // private RestTemplate restTemplate;

    // public ResponseEntity<ResponseBase> getYoutubeVideo() {
        
    //     HttpHeaders httpsheaders = new HttpHeaders();
    //     httpsheaders.set("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
        
    //     MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
    //     paramMap.add("q"    , "한사랑산악회"); 

    //     HttpEntity reqhttpEntity = new HttpEntity(paramMap, httpsheaders);

    //     log.info("요청: " + paramMap.toString());

    //     ResponseEntity<VdYoutubeDto.Res> resHttpEntity = this.restTemplate.exchange(YOUTUBE_URI, HttpMethod.GET, reqhttpEntity, VdYoutubeDto.Res.class);

    //     log.info("응답: " + resHttpEntity.getBody().toString());

    //     return ResponseHelper.success(); 
    // }
 
    







    
}
