package com.example.springcore1.repository;


import com.example.springcore1.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByOrderByModifiedAtDesc();

//    List<Blog> findAllById(Long id);
}
