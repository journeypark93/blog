package com.example.springcore1.validator;

import com.example.springcore1.dto.UserRequestDto;
import com.example.springcore1.model.User;
import com.example.springcore1.model.UserRoleEnum;
import com.example.springcore1.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.Errors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Objects;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CheckUsernameValidatorTest {

    @Mock
    UserRepository userRepository;
    UserRequestDto dto;
    Errors errors;
    User user;


@Test
public void validation_테스트(){
        ValidatorFactory validatorFactory= Validation.buildDefaultValidatorFactory();
        Validator validator=validatorFactory.getValidator();

        UserRequestDto dto=new UserRequestDto();

        dto.setEmail("mindh890@gmail.com");
        dto.setUsername("abcdefg");
        dto.setPassword("1234a");
        dto.setPassword2("1234a");
        Set<ConstraintViolation<User>> violations=validator.validate(user);

        System.out.println("violations : "+violations.toString());

        //유효성이 성공적으로 통과됐으면 empty
        //그렇지 않으면 not empty
        assertTrue(violations.isEmpty());

        validatorFactory.close();

        }
}