package com.emotion.em.service;

import java.time.LocalDateTime;
import java.util.List; 
import com.emotion.em.Dto.DiaryContents;
import com.emotion.em.Entity.TbDiaryContents;
import com.emotion.em.Entity.TbDiaryTitle;  
import org.springframework.stereotype.Service;  

@Service 
public class EmDiarySaveService {

    final EmDiarySaveDomainService emDiarySaveDomainService;

    public EmDiarySaveService(EmDiarySaveDomainService emDiarySaveDomainService) {
        this.emDiarySaveDomainService = emDiarySaveDomainService;
    }

    public DiaryContents createDiary(DiaryContents diaryContents) {
     
        TbDiaryContents tbDiaryContents = new TbDiaryContents(); 
        TbDiaryTitle tbDiaryTitle = new TbDiaryTitle(); 

        tbDiaryContents.setContents(diaryContents.getContents());
        
        tbDiaryTitle.setTitle(diaryContents.getTitle());
        tbDiaryTitle.setDate(LocalDateTime.now());
        tbDiaryTitle.setEmotionCd(diaryContents.getEmotion_cd());

        tbDiaryContents = emDiarySaveDomainService.createDiary(tbDiaryContents);
        tbDiaryTitle = emDiarySaveDomainService.createDiaryTitle(tbDiaryTitle);
        
        // Key 값.. 
        diaryContents.setNo(Integer.toString(tbDiaryTitle.getNo()));
         
        return diaryContents;
    }

    public DiaryContents selectDiary(String no) {
        TbDiaryContents tbDiaryContents = emDiarySaveDomainService.selectDiary(no);
        TbDiaryTitle tbDiaryTitle = emDiarySaveDomainService.selectTitle(no);    
        DiaryContents diaryContents = new DiaryContents();
 
        diaryContents.setContents(tbDiaryContents.getContents());
        diaryContents.setTitle(tbDiaryTitle.getTitle());
        diaryContents.setEmotion_cd(tbDiaryTitle.getEmotionCd());
        diaryContents.setDate(tbDiaryTitle.getDate());
        return diaryContents;
    } 


    public List<TbDiaryTitle> selectTitleAll() {         
        return emDiarySaveDomainService.selectTitleAll();
    }

    public List<TbDiaryTitle> selectTitleByEmotionCode(String emotion_cd) {         
        return emDiarySaveDomainService.selectTitleByEmotionCd(emotion_cd);
    }








}
