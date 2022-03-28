//필요없을 것 같으니 마지막에 지워보쟝!  userrequestdto 에 다시 만ㄷ르으므음ㄹ

package com.example.springcore1.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {
    private String username;
    private String password;
    private String email;
    private boolean admin = false;
    private String adminToken = "";
}
