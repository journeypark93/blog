package com.example.springcore1.model;

import com.example.springcore1.dto.BlogRequestDto;
import com.example.springcore1.time.Timestamped;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor //기본생성자 생성해줌
@Setter
@Getter  //생성자에 대한 getter 생성해줌
@Entity //테이블과 연관됨을 스프링에게 알림
public class Blog extends Timestamped {
    //id 자동으로 증가하여 db에 저장, id로 식별
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;


    //생성자 생성
    public Blog(String title, String username, String contents){
        this.title = title;
        this.username = username;
        this.contents = contents;
    }

    public Blog(BlogRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }


    //update 기능
    public void update(BlogRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }
}
