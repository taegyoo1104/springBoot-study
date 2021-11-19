package com.example.springpractice.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity  //테이블과 링크될 클래스
public class Posts {

    @Id //필드의 pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    //Entity 클래스에서는 setter 메소드를 만들지 않는다
    //필드의 값을 변경하기 위해서는 목적과 의도를 나타낼 수 있는 메소드를 추가해야함

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
