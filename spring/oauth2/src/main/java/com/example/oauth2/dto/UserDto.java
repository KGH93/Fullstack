package com.example.oauth2.dto;

import com.example.oauth2.entity.Users;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDto {
    @NotBlank(message = "아이디는 필수 입력값")
    private String userId;
    @NotBlank(message = "이름은 필수 입력값")
    private String name;
    @NotBlank(message = "비밀번호는 필수 입력값")
    private String userPw;
    @NotBlank(message = "이메일은 필수 입력값")
    private String email;
    @NotBlank(message = "전화번호는 필수 입력값")
    private String phone;
    @NotBlank(message = "주소는 필수 입력값")
    private String p_code;
    @NotBlank(message = "주소는 필수 입력 값입니다.")
    private String loadAddr;

    @NotBlank(message = "주소는 필수 입력 값입니다.")
    private String lotAddr;

    @NotBlank(message = "주소는 필수 입력 값입니다.")
    private String detailAddr;

    private String extraAddr; // 추가된 필드

    public UserDto(Users user) {
        this.userId = user.getUserId();
        this.userPw = user.getUserPw();
        this.name = user.getName();
        this.p_code = user.getPCode();
        this.phone = user.getPhone();
        this.loadAddr = user.getLoadAddr();
        this.lotAddr = user.getLotAddr();
        this.detailAddr = user.getDetailAddr();
        this.extraAddr = user.getExtraAddr(); // 추가된 필드 초기화
        this.email = user.getEmail();
    }
}
