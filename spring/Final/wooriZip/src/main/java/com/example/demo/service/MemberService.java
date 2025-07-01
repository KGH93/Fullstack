package com.example.demo.service;

import com.example.demo.dto.MemberDto;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member signUp(MemberDto dto) {
        Member member = new Member();
        member.setUserPw(passwordEncoder.encode(dto.getUserPw())); // 🔥 암호화
        member.setPhone(dto.getPhone());
        member.setEmail(dto.getEmail());
        member.setNickname(dto.getNickname());
        member.setGender(dto.getGender());
        member.setBirth(dto.getBirth());
        member.setP_code(dto.getP_code());
        member.setLoadAddr(dto.getLoadAddr());
        member.setLotAddr(dto.getLotAddr());
        member.setDetailAddr(dto.getDetailAddr());
        member.setExtraAddr(dto.getExtraAddr());
        member.setResidenceType(dto.getResidenceType());

        return memberRepository.save(member);
    }
}
