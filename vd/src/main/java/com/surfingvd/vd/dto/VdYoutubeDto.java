package com.surfingvd.vd.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter 
public class VdYoutubeDto implements Serializable {

    @ToString
    @Getter
    @Setter
    public static class Req {

        String q;
        String key;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @ToString
    @Getter
    @Setter
    public static class Res {
        
        String kind;
        String etag;
        String nextPageToken;
        String regionCode;    
        List<pageInfo> pageInfo; 
        
        public static class pageInfo {
            int totalResults;
            int resultsPerPage;
        } 

    }


    
}
