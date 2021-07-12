package com.sprayou.spray.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.sprayou.spray.dao.BatchDao;
import com.sprayou.spray.dto.VendorDto;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
 

import java.net.URLEncoder;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Service
@Component
@Slf4j
public class VendorServiceImpl implements VendorService {
 
    private RestTemplate restTemplate;
    private final String DOMAIN = "https://openapi.naver.com";
    private final String PREFIX = "/v1/search";
    private final String NAVER_SHOP_SEARCH_API_URI = DOMAIN + PREFIX + "/shop.json";

    private final String CLIENTID = "qpMqZ3dpzWdWjgO1EPwd"; //애플리케이션 클라이언트 아이디값"
    private final String CLIENTSECRET = "gpeJ2dn80Z"; //애플리케이션 클라이언트 시크릿값"
       

    @Override
    public  void findToShopAll() {

        // HttpHeaders httpHeaders = new HttpHeaders();        
        // httpHeaders.set("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
        // httpHeaders.set("X-Naver-Client-Id", "qpMqZ3dpzWdWjgO1EPwd");
        // httpHeaders.set("X-Naver-Client-Secret", "gpeJ2dn80Z");

        // MultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<>();

        // paramsMap.add("query", "%EC%9B%90%ED%94%BC%EC%8A%A4");
        // paramsMap.add("display", "10");
        // paramsMap.add("start", "1");
        // paramsMap.add("sort", "date");

        // HttpEntity reqHttpEntity = new HttpEntity(paramsMap, httpHeaders);

        // ResponseEntity<VendorDto.Info> restHttpEntity = this.restTemplate.exchange(NAVER_SHOP_SEARCH_API_URI, HttpMethod.GET, reqHttpEntity, VendorDto.Info.class );

        // log.info("Req: "  + restHttpEntity.getBody().toString());
        

        // return restHttpEntity; 

        

        String text = null;
        try {
            text = URLEncoder.encode("원피스", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패",e);
        }

        String apiURL = NAVER_SHOP_SEARCH_API_URI + "?query=" + text + "&display=1&start=1&sort=date";    // json 결과
        //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id"      , CLIENTID);
        requestHeaders.put("X-Naver-Client-Secret"  , CLIENTSECRET);
        String responseBody = get(apiURL, requestHeaders);

        System.out.println(responseBody);

        
  
        


 
    }



    private static String get(String apiUrl, Map<String, String> requestHeaders){
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return readBody(con.getInputStream());



                
            } else { // 에러 발생
                return readBody(con.getErrorStream());




            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }

    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

    private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }



    
}
