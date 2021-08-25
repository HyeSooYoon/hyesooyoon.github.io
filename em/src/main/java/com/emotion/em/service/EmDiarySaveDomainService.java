package com.emotion.em.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
 
import com.emotion.em.Entity.TbDiaryContents;
import com.emotion.em.Entity.TbDiaryTitle;
import com.emotion.em.repository.DiaryRepository;
import com.emotion.em.repository.DiaryTitleRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor; 

@Service 
@RequiredArgsConstructor  
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

    @Transactional 
    public TbDiaryContents selectDiary(String no) {
        Optional<TbDiaryContents> diary = diaryRepository.findTbDiaryContentsByNo(Integer.parseInt(no));
        if (!diary.isPresent()) 
            throw new RuntimeException("diary, not found :" + no);
        return diary.get();
    }

    @Transactional 
    public TbDiaryTitle selectTitle(String no) {
        Optional<TbDiaryTitle> diary = diaryTitleRepository.findTbDiaryTitleByNo(Integer.parseInt(no));
        if (!diary.isPresent()) 
            throw new RuntimeException("diary title, not found :" + no);
        return diary.get();
    }

    @Transactional 
    public List<TbDiaryTitle> selectTitleAll() {
        return diaryTitleRepository.findAll();
    }

    



}
