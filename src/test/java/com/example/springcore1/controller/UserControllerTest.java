package com.example.springcore1.controller;

import com.example.springcore1.dto.UserRequestDto;
import com.example.springcore1.model.UserRoleEnum;
import com.example.springcore1.repository.UserRepository;
import com.example.springcore1.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.RequestPostProcessor;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class UserControllerTest {


    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @DisplayName("회원 가입 처리 - 입력값 오류")
    @Test
    void signUp_error() throws Exception {

        // 비밀 번호 불일치
        mockMvc.perform(post("/signup")
                        .param("username", "abc")
                        .param("email", "email@gmail.com")
                        .param("password", "12345")
                        .param("password2", "11111"));

        // 올바르지 않은 닉네임
        mockMvc.perform(post("/signup")
                        .param("username", "!?@")
                        .param("email", "email@gmail.com")
                        .param("password", "1234")
                        .param("password2", "1234"));

        // 비밀번호와 닉네임 일치
        mockMvc.perform(post("/signup")
                        .param("username", "1234")
                        .param("email", "email@gmail.com")
                        .param("password", "1234")
                        .param("password2", "1234"));
    }
}
