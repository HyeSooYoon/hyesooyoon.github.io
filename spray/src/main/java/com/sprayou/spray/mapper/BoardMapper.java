package com.sprayou.spray.mapper;


import com.sprayou.spray.dto.BoardDto;
import com.sprayou.spray.dto.CosmeticsDto;
import com.sprayou.spray.dto.VoteDto;

import java.util.List;

public interface BoardMapper {
    List<BoardDto> list(String type);
    BoardDto detail(String num);
    int save(BoardDto boardDto);
    int saveVote(VoteDto voteDto);
    int viewCount(BoardDto boardDto);
    int voteCount(CosmeticsDto cosmeticsDto);

}