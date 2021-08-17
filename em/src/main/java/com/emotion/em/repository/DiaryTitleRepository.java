package com.emotion.em.repository;

import com.emotion.em.Entity.TbDiaryTitle;
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

@Repository
public interface DiaryTitleRepository extends JpaRepository<TbDiaryTitle, Long> {


    
}
