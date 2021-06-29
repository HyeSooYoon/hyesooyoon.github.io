package com.sprayou.spray.service;

import com.sprayou.spray.dao.BoardDao;
import com.sprayou.spray.dto.BoardDto;
import com.sprayou.spray.dto.CosmeticsDto;
import com.sprayou.spray.dto.VoteDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDao boardDao;

    @Override
    public List<BoardDto> list(String type) {
        return boardDao.selectBoardList(type);
    }

    @Override
    public BoardDto detail(String num) {
        return boardDao.selectBoardDetail(num);
    }

    @Override
    public int save(BoardDto boardDto) {
        return boardDao.save(boardDto);
    }

    @Override
    public int saveVote(VoteDto voteDto) {
        return boardDao.saveVote(voteDto);
    }

    @Override
    public int viewCount(BoardDto boardDto) {
        return boardDao.viewCount(boardDto);
    }

    @Override
    public int voteCount(CosmeticsDto cosmeticsDto) {
        return boardDao.voteCount(cosmeticsDto);
    }

    @Override
    public VoteDto countVote(VoteDto voteDto) {
        return boardDao.countVote(voteDto);
    }
}
