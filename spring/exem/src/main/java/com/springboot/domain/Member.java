package com.springboot.domain;

import jakarta.validation.constraints.Size;
import lombok.Data; //아래 세개 한번에 기능
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data   
public class Member {
//    private String id;
//    private int passwd;
//    private String city;
//    private String sex;
//    private String[] hobby;
//    private String greetings;
    
    @MemberId
    private String memberId;
    
    @Size(min=4, max=10, message = "4~10자 이내로 입력해 주세요")
    private String passwd;
}
