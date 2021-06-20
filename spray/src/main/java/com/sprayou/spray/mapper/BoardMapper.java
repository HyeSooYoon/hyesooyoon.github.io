package com.sprayou.spray.mapper;


import com.sprayou.spray.dto.BoardDto;

import java.util.List;

public interface BoardMapper {
    List<BoardDto> list();
    BoardDto detail(String num);
    int save(BoardDto boardDto);
    int viewCount(BoardDto boardDto);

}