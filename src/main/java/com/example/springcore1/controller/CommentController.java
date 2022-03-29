package com.example.springcore1.controller;

import com.example.springcore1.dto.BlogRequestDto;
import com.example.springcore1.dto.CommentRequestDto;
import com.example.springcore1.model.Comment;
import com.example.springcore1.repository.CommentRepository;
import com.example.springcore1.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentRepository commentRepository;
    private final CommentService commentService;


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

    //삭제(Delete)
    @DeleteMapping("/api/comments/{id}")
    public Long deleteComment(@PathVariable Long id) {
        commentRepository.deleteById(id);
        return id;
    }

    //수정(Update)
    @PutMapping("/api/comments/{id}")
    public Long updateComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto) {
        return commentService.update(id, requestDto);
    }

}
