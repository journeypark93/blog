package com.example.springcore1.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BlogRequestDto {
    private String title;
    private String username;
    private String contents;
}

