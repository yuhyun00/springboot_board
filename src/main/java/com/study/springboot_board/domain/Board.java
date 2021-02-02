package com.study.springboot_board.domain;

import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "board_id")
    private Long id;

    @Column(length = 50, nullable = false)
    private String boardTitle;

    @Lob
    private String boardContent;

    @Column
    private String userName;

    //작성시간
//    private LocalDateTime createdDate;

    //로그인 후 글쓴이
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;

    @Builder
    public Board(String boardTitle, String boardContent, String userName) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.userName = userName;
    }
}
