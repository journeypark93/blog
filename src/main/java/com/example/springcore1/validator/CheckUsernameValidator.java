package com.example.springcore1.validator;

import com.example.springcore1.dto.UserRequestDto;
import com.example.springcore1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.util.Objects;

@RequiredArgsConstructor
@Component
public class CheckUsernameValidator extends AbstractValidator<UserRequestDto> {
    private final UserRepository userRepository;


    @Override
    protected void doValidate(UserRequestDto dto, Errors errors) {
        //아이디 중복 여부
        if (userRepository.existsByUsername(dto.getUsername())) {
            errors.rejectValue("username", "아이디 중복 오류", "이미 사용중인 아이디 입니다.");
        }

        // 비밀번호 일치 여부
        String userPwd = dto.getPassword();
        String pwdCheck = dto.getPassword2();
        if(!Objects.equals(userPwd, pwdCheck)) {
            errors.rejectValue("password2", "비밀번호 일치 오류", "비밀번호가 일치하지 않습니다.");
        }


        // 회원 ID, Password 포함여부
        if (userPwd.contains(dto.getUsername())) {
            errors.rejectValue("password", "아이디 포함 오류", "비밀번호에 아이디를 포함할 수 없습니다.");
        }

        //이메일 중복 여부
        if (userRepository.existsByEmail(dto.getEmail())) {
            errors.rejectValue("email", "이메일 포함 오류", "이미 등록된 이메일입니다.");
        }
    }
}

