package com.emotion.em.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tb_diary_title")
public class TbDiaryTitle {
    
    @Id
    @Column(name="no")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int no;
    
    @Column(name="title", nullable = false, length=50)
    private String title;
    
    @Column(name="date", nullable = false)
    private LocalDateTime date;
    
    @Column(name="emotion_cd", nullable = false, length=4)
    private String emotion_cd; 

}
 