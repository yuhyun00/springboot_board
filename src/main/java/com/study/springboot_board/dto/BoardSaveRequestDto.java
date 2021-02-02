package com.study.springboot_board.dto;

import com.study.springboot_board.domain.Board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardSaveRequestDto {

    private String boardTitle;
    private String boardContent;
    private String userName;

    @Builder
    public BoardSaveRequestDto(String boardTitle, String boardContent, String userName) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.userName = userName;
    }
    public Board toEntity() {
        return Board.builder()
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .userName(userName)
                .build();
    }
}

