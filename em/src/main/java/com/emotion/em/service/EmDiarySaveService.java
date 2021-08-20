package com.emotion.em.service;

import java.time.LocalDateTime;
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
        tbDiaryTitle.setEmotion_cd("EM01");

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
        diaryContents.setEmotion_cd(tbDiaryTitle.getEmotion_cd());
        diaryContents.setDate(tbDiaryTitle.getDate());
        return diaryContents;
    }








}
