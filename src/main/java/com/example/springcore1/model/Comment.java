package com.example.springcore1.model;

import com.example.springcore1.dto.CommentRequestDto;
import com.example.springcore1.time.Timestamped;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor //기본생성자 생성해줌
@Setter
@Getter  //생성자에 대한 getter 생성해줌
@Entity //테이블과 연관됨을 스프링에게 알림

public class Comment extends Timestamped {
    //id 자동으로 증가하여 db에 저장, id로 식별
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private Long userid;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String comments;


    //생성자 생성
    public Comment(Long userid, String username, String comments){
        this.userid = userid;
        this.username = username;
        this.comments = comments;
    }

    public Comment(CommentRequestDto requestDto){
        this.userid = requestDto.getUserid();
        this.username = requestDto.getUsername();
        this.comments = requestDto.getComments();
    }


    //update 기능
    public void update(CommentRequestDto requestDto){
        this.userid = requestDto.getUserid();
        this.username = requestDto.getUsername();
        this.comments = requestDto.getComments();
    }
}
