package com.sprayou.spray.service;


import com.sprayou.spray.dto.BoardDto;
import com.sprayou.spray.dto.CosmeticsDto;
import com.sprayou.spray.dto.UserDto;

import java.util.List;

public interface BoardService {

    List<BoardDto> list(String type);
    BoardDto detail(String num);
    int save(BoardDto boardDto);
    int viewCount(BoardDto boardDto);
    int voteCount(CosmeticsDto boardDto);

}
