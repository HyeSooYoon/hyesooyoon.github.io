package com.sprayou.spray.dao;

import com.sprayou.spray.mapper.BatchMapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BatchDao {
    
    @Autowired
    private SqlSession sqlSession;

    public int deleteVote() {
        return sqlSession
                .getMapper(BatchMapper.class)
                .deleteVote();
    }

    public int deleteCosmeticVote() {
        return sqlSession
                .getMapper(BatchMapper.class)
                .deleteCosmeticVote();
    }
}
