package com.emotion.em.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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
     
        String uuid = UUID.randomUUID().toString();
        
        TbDiaryContents tbDiaryContents = new TbDiaryContents(); 
        TbDiaryTitle tbDiaryTitle = new TbDiaryTitle();         
        
        tbDiaryTitle.setTitle(diaryContents.getTitle());
        tbDiaryTitle.setDate(LocalDateTime.now());
        tbDiaryTitle.setEmotionCd(diaryContents.getEmotion_cd());
        tbDiaryTitle.setUuid(uuid);
         
        tbDiaryContents.setContents(diaryContents.getContents());
        tbDiaryContents.setUuid(uuid);

        tbDiaryTitle = emDiarySaveDomainService.createDiaryTitle(tbDiaryTitle);
        tbDiaryContents = emDiarySaveDomainService.createDiary(tbDiaryContents);        
        
        // Key 값.. 
        diaryContents.setUuid(tbDiaryTitle.getUuid());
         
        return diaryContents;
    }

    public DiaryContents selectDiary(String uuid) {
        TbDiaryContents tbDiaryContents = emDiarySaveDomainService.selectDiary(uuid);
        TbDiaryTitle tbDiaryTitle = emDiarySaveDomainService.selectTitle(uuid);    
        DiaryContents diaryContents = new DiaryContents();
 
        diaryContents.setContents(tbDiaryContents.getContents());
        diaryContents.setTitle(tbDiaryTitle.getTitle());
        diaryContents.setEmotion_cd(tbDiaryTitle.getEmotionCd());
        diaryContents.setDate(tbDiaryTitle.getDate());
        return diaryContents;
    } 


    public List<TbDiaryTitle> selectTitleAllByEmotionCdDesc() {         
        return emDiarySaveDomainService.selectTitleAllByEmotionCdDesc();
    }

    public List<TbDiaryTitle> selectTitleByEmotionCode(String emotion_cd) {         
        return emDiarySaveDomainService.selectTitleByEmotionCd(emotion_cd);
    }








}
