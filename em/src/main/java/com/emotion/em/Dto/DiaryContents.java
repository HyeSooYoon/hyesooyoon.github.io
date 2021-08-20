package com.emotion.em.Dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
 
import lombok.Data;

@Data
public class DiaryContents implements Serializable {
 
    @NotEmpty
    String contents;        

    @NotEmpty
    String title;      

    String no;
    
    LocalDateTime date;
    
    String emotion_cd; 
 

}
