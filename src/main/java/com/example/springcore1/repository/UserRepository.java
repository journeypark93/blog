package com.example.springcore1.repository;

import com.example.springcore1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findByKakaoId(Long kakaoId);
    //중복확인
    boolean existsByUsername(String username);

    //중복확인
    boolean existsByEmail(String email);
}
