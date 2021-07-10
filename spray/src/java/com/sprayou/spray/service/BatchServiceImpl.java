package com.sprayou.spray.service;

import com.sprayou.spray.dao.BatchDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class BatchServiceImpl implements BatchService {

    @Autowired
    private BatchDao batchDao;

    @Override
    public int deleteVote() {
        return batchDao.deleteVote();
    }

    @Override
    public int deleteCosmeticVote() {
        return batchDao.deleteCosmeticVote();
    }

    
}
