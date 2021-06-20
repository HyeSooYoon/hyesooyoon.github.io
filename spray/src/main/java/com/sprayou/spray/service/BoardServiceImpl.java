package com.sprayou.spray.service;

import com.sprayou.spray.dao.BoardDao;
import com.sprayou.spray.dto.BoardDto;
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
    public List<BoardDto> list() {
        return boardDao.selectBoardList();
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
    public int viewCount(BoardDto boardDto) {
        return boardDao.viewCount(boardDto);
    }
}
