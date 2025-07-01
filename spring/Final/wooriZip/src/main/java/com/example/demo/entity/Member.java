package com.example.demo.entity;

import com.example.demo.dto.MemberDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;

    private String userPw;
    private String phone;
    private String nickname;
    private String gender;

    private LocalDate birth;

    @Column(name = "p_code", nullable = false)
    private String p_code;

    @Column(name = "loadAddr", nullable = false)
    private String loadAddr;

    @Column(name = "lotAddr", nullable = false)
    private String lotAddr;

    @Column(name = "detailAddr", nullable = false)
    private String detailAddr;

    @Column(name = "extraAddr")
    private String extraAddr;

    private int residenceType;

    @Builder
    public Member(String userPw, String phone, String email, String nickname,
                  String gender, LocalDate birth, String p_code, String loadAddr, String lotAddr,
                  String detailAddr, String extraAddr, int residenceType) {
        this.userPw = userPw;
        this.phone = phone;
        this.email = email;
        this.nickname = nickname;
        this.gender = gender;
        this.birth = birth;
        this.p_code = p_code;
        this.loadAddr = loadAddr;
        this.lotAddr = lotAddr;
        this.detailAddr = detailAddr;
        this.extraAddr = extraAddr;
        this.residenceType = residenceType;
    }

    public static Member createMember(MemberDto dto, PasswordEncoder passwordEncoder) {
        return Member.builder()
                .userPw(passwordEncoder.encode(dto.getUserPw()))
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .nickname(dto.getNickname())
                .gender(dto.getGender())
                .birth(dto.getBirth())
                .p_code(dto.getP_code())
                .loadAddr(dto.getLoadAddr())
                .lotAddr(dto.getLotAddr())
                .detailAddr(dto.getDetailAddr())
                .extraAddr(dto.getExtraAddr())
                .residenceType(dto.getResidenceType())
                .build();
    }
}
