//유효성 검사

package com.example.springcore1.dto;

import com.example.springcore1.model.UserRoleEnum;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@Data
@NoArgsConstructor
public class UserRequestDto {

    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    @Pattern(regexp = "[a-zA-Z0-9]{3,100}$", message = "아이디는 특수문자, 한글을 제외한 3자리 이상입니다.")
    private String username;

    @Size(min=4, message = "비밀번호는 4자이상입니다.")
    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    private String password;

    @NotBlank(message = "비밀번호확인은 필수 입력 값입니다.")
    private String password2;

    @Email(message = "이메일 형식에 맞지 않습니다.")
    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    private String email;

    private boolean admin = false;
    private String adminToken = "";

}

