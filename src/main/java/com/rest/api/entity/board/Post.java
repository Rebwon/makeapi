package com.rest.api.entity.board;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rest.api.entity.User;
import com.rest.api.entity.common.CommonDateEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends CommonDateEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(nullable = false, length = 50)
    private String author;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(length = 500)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board; // 게시글 - 게시판의 관계 N:1

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "msrl")
    private User user;  // 게시글 - 회원의 관계 N:1

    // Join 테이블이 Json 결과에 표시되지 않도록 처리
    @JsonIgnore
    protected Board getBoard(){
        return board;
    }

    public Post(User user, Board board, String author, String title, String content) {
        this.user = user;
        this.board = board;
        this.author = author;
        this.title = title;
        this.content = content;
    }

    // 수정시 데이터 처리
    public Post setUpdate(String author, String title, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
        return this;
    }
}

