package com.example.springcore1.controller;

import com.example.springcore1.dto.BlogRequestDto;
import com.example.springcore1.model.Blog;
import com.example.springcore1.repository.BlogRepository;
import com.example.springcore1.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class WriteController {
    private final BlogRepository blogRepository;


    //생성(Create)
    @PostMapping("/blogs")
    public Blog createBlog(@RequestBody BlogRequestDto requestDto){
        Blog blog = new Blog(requestDto);
        return blogRepository.save(blog);
    }

    //조회(Read)
    @GetMapping("api/blogs")
    public List<Blog> getBlog(){
        return blogRepository.findAllByOrderByModifiedAtDesc();
    }


}
