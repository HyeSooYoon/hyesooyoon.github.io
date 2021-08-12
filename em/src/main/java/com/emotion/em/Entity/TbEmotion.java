package com.emotion.em.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_emotion")
public class TbEmotion { 
    
    @Id
    @Column(name="emotion_cd", nullable = false, length=4)
    private int emotion_cd;
    
    @Column(name="emotion_st", nullable = false, length=20)
    private String emotion_st;
  
}
