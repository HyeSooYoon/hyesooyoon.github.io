package com.sprayou.spray.dao;
import com.sprayou.spray.dto.BoardDto;
import com.sprayou.spray.dto.CosmeticsDto;
import com.sprayou.spray.dto.UserDto;
import com.sprayou.spray.mapper.BoardMapper;
import com.sprayou.spray.mapper.UserMapper;
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




}
