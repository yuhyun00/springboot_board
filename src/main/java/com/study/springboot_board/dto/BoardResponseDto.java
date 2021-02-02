package com.study.springboot_board.dto;

import com.study.springboot_board.domain.Board;
import lombok.Getter;

@Getter
public class BoardResponseDto {

    private Long id;
    private String boardTitle;
    private String boardContent;
    private String userName;

    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.boardTitle = board.getBoardTitle();
        this.boardContent = board.getBoardContent();
        this.userName = board.getUserName();
    }
}

