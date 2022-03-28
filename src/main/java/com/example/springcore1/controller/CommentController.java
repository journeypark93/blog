package com.example.springcore1.controller;

import com.example.springcore1.dto.CommentRequestDto;
import com.example.springcore1.model.Comment;
import com.example.springcore1.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentRepository commentRepository;


    //생성(Create)
    @PostMapping("/comments")
    public Comment createComment(@RequestBody CommentRequestDto requestDto){
        Comment comment = new Comment(requestDto);
        return commentRepository.save(comment);
    }


    //조회(Read)
    @GetMapping("/api/comments")
    public List<Comment> getComment(){
        return commentRepository.findAllByOrderByModifiedAtDesc();
    }


}
