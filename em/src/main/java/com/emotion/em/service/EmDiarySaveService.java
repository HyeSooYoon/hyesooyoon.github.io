package com.emotion.em.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import com.emotion.em.Dto.DiaryContents;
import com.emotion.em.Entity.TbDiaryContents;
import com.emotion.em.Entity.TbDiaryTitle;
import com.emotion.em.repository.DiaryRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmDiarySaveService {

    final EmDiarySaveDomainService emDiarySaveDomainService;

    public EmDiarySaveService(EmDiarySaveDomainService emDiarySaveDomainService) {
        this.emDiarySaveDomainService = emDiarySaveDomainService;
    }

    public DiaryContents.Req createDiary(DiaryContents.Req diaryContents) {
     
        TbDiaryContents tbDiaryContents = new TbDiaryContents(); 
        TbDiaryTitle tbDiaryTitle = new TbDiaryTitle(); 

        tbDiaryContents.setContents(diaryContents.getContents());
        
        tbDiaryTitle.setTitle(diaryContents.getTitle());
        tbDiaryTitle.setDate(LocalDateTime.now());
        tbDiaryTitle.setEmotion_cd("EM01");

        tbDiaryContents = emDiarySaveDomainService.createDiary(tbDiaryContents);
        tbDiaryTitle = emDiarySaveDomainService.createDiaryTitle(tbDiaryTitle);
         
        return diaryContents;
}



}
