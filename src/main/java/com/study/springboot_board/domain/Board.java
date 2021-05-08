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
    @Column
    private Long boardId;

    @Column(length = 50, nullable = false)
    private String boardTitle;

    @Lob
    @Column(nullable = false)
    private String boardContent;

    @Column(length = 20, nullable = false)
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

    public void update(String boardTitle, String boardContent) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
    }
}
