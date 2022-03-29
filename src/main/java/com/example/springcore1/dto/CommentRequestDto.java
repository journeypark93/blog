package com.example.springcore1.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentRequestDto {
    private Long Id;
    private Long userid;
    private String username;
    private String comments;
}

