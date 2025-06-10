package com.springboot.domain;

import lombok.Data; //아래 세개 한번에 기능
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data   
public class Member {
    private String id;
    private int passwd;
    private String city;
    private String sex;
    private String[] hobby;
    private String greetings;
}
