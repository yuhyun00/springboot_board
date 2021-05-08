package com.study.springboot_board.dto;

import com.study.springboot_board.domain.Board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class BoardSaveRequestDto {

    @NotEmpty(message = "제목은 필수 입니다.")
    @Size(max = 50, message = "제목은 50자리를 초과할 수 없습니다.")
    private String boardTitle;

    @NotEmpty(message = "내용은 필수 입니다.")
    private String boardContent;

    @NotEmpty(message = "이름은 필수 입니다.")
    @Size(max = 20, message = "이름은 20자리를 초과할 수 없습니다.")
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

