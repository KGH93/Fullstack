package  Board.Kgh.service;

import Board.Kgh.dto.MemberDTO;
import Board.Kgh.entity.Member;
import Board.Kgh.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;


    public Member register(MemberDTO dto) {
        Member member = new Member();
        member.setUsername(dto.getUsername());
        member.setPassword(dto.getPassword());
        return memberRepository.save(member);
    }

    public Member login(MemberDTO dto) {
        return memberRepository.findByUsername(dto.getUsername())
                .filter(m -> m.getPassword().equals(dto.getPassword()))
                .orElse(null);
    }

    public void changePassword(Long id, String newPassword) {
        Member member = memberRepository.findById(id).orElseThrow(()-> new RuntimeException("회원을 찾을 수 없음"));
        member.setPassword(newPassword);
        memberRepository.save(member);
    }
}
