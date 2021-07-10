package com.sprayou.spray.controller;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;
 
import com.sprayou.spray.service.BatchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component; 

@Slf4j
@Component
public class BatchController {
      
    @Autowired
    private BatchService batchService;

    // 초/분/시/일/월/요일
    // 매주 일요일 오전 2시 
    @Scheduled(cron = "0 0 2 * * 0")
    public void deleteVote() {
        log.info("투표 목록 초기화" + LocalTime.now());        
        batchService.deleteVote();
    }
    
    @Scheduled(cron = "0 0 2 * * 0")
    public void deleteCosmeticVote() {
        log.info("품목 투표 수량 초기화" + LocalTime.now());        
        batchService.deleteCosmeticVote();
    } 
    
}
