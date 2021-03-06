package com.example.springcore1.controller;

import com.example.springcore1.dto.BlogRequestDto;
import com.example.springcore1.model.Blog;
import com.example.springcore1.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    //삭제(Delete)
    @DeleteMapping("/api/blogs/{id}")
    public Long deleteCourse(@PathVariable Long id) {
        blogRepository.deleteById(id);
        return id;
    }
}
