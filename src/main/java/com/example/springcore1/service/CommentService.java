package com.example.springcore1.service;

import com.example.springcore1.dto.CommentRequestDto;
import com.example.springcore1.model.Comment;
import com.example.springcore1.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional //이거 꼭 db에 저장해줘!!
    public Long update(Long id, CommentRequestDto requestDto){
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        comment.update(requestDto);
        return comment.getId();
    }
}

