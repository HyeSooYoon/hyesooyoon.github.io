package com.sprayou.spray.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto implements Serializable {

     /*
      no
     title
     writer
     regdte
     updte
     readcnt
     content
      */
    private String no;
    private String title;
    private String writer;
    private String regdte;
    private String updte;
    private String readcnt;
    private String content;
}