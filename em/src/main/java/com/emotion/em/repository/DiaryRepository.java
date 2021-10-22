package com.emotion.em.repository;

import com.emotion.em.Entity.TbDiaryContents;
import com.emotion.em.Entity.TbDiaryTitle;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository; 
import java.util.Optional;

@Repository
public interface DiaryRepository extends JpaRepository<TbDiaryContents, Long> {

    Optional<TbDiaryContents> findTbDiaryContentsByUuid(String uuid);

    

    
}
