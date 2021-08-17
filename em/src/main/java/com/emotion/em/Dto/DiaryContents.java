package com.emotion.em.Dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class DiaryContents implements Serializable {

    @Data
    public static class Req {
  
        @NotEmpty
        String contents;        

        @NotEmpty
        String title;
 
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class Res {
       
        String code;
        String message;
    } 

    
}
