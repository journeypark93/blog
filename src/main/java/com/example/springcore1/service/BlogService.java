package com.example.springcore1.service;


import com.example.springcore1.dto.BlogRequestDto;
import com.example.springcore1.model.Blog;
import com.example.springcore1.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    @Transactional //이거 꼭 db에 저장해줘!!
    public Long update(Long id, BlogRequestDto requestDto){
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        blog.update(requestDto);
        return blog.getId();
    }
}

