package com.sprayou.spray.dao;
import com.sprayou.spray.dto.BoardDto;
import com.sprayou.spray.dto.CosmeticsDto;
import com.sprayou.spray.dto.VoteDto;
import com.sprayou.spray.mapper.BoardMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDao {

    @Autowired
    private SqlSession sqlSession;

    public List<BoardDto> selectBoardList(String type) {
        return sqlSession
                .getMapper(BoardMapper.class)
                .list(type);
    }

    public BoardDto selectBoardDetail(String num) {
        return sqlSession
                .getMapper(BoardMapper.class)
                .detail(num);
    }

    public int save(final BoardDto boardDto) {
        return sqlSession
                .getMapper(BoardMapper.class)
                .save(boardDto);
    }

    public int saveVote(final VoteDto voteDto) {
        return sqlSession
                .getMapper(BoardMapper.class)
                .saveVote(voteDto);
    }

    public int viewCount(final BoardDto boardDto) {
        return sqlSession
                .getMapper(BoardMapper.class)
                .viewCount(boardDto);
    }

    public int voteCount(final CosmeticsDto cosmeticsDto) {
        return sqlSession
                .getMapper(BoardMapper.class)
                .voteCount(cosmeticsDto);
    }

    public VoteDto countVote(final VoteDto voteDto) {
        return sqlSession
                .getMapper(BoardMapper.class)
                .countVote(voteDto);
    }
    



}
