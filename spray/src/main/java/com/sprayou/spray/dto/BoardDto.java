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

    private String no;

    private String title;

    private String writer;

    private String regdte;

    private String updte;

    private String readcnt;

    private String content;

    private String productCd;
    
    private String boardType;

    private String voteCnt;
}
