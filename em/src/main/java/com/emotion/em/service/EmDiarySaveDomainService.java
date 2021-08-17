package com.emotion.em.service;

import javax.transaction.Transactional;
 
import com.emotion.em.Entity.TbDiaryContents;
import com.emotion.em.Entity.TbDiaryTitle;
import com.emotion.em.repository.DiaryRepository;
import com.emotion.em.repository.DiaryTitleRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service 
@RequiredArgsConstructor 
@Slf4j
public class EmDiarySaveDomainService {

    private final DiaryRepository diaryRepository;
    private final DiaryTitleRepository diaryTitleRepository;

    @Transactional 
    public TbDiaryContents createDiary(TbDiaryContents tbDiaryContents) { 
        tbDiaryContents = diaryRepository.save(tbDiaryContents); 
        return tbDiaryContents; 
    }

    @Transactional 
    public TbDiaryTitle createDiaryTitle(TbDiaryTitle tbDiaryTitle) { 
        tbDiaryTitle = diaryTitleRepository.save(tbDiaryTitle); 
        return tbDiaryTitle; 
    }


    



}
