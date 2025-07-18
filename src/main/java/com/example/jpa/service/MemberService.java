package com.example.jpa.service;

import com.example.jpa.entity.MemberEntity;
import com.example.jpa.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    public final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void save(MemberEntity member) {
        memberRepository.save(member);
    }

    public MemberEntity findByUsername(String username) {
        return memberRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("사용자를 첮을 수 없습니다.")); // 만약 찾지 못했다면 이어질 chain
    }

    public void update(String username, String name, String password) {
        MemberEntity member = findByUsername(username);
        member.setName(name);
        member.setPassword(password);
        memberRepository.save(member);
    }
}
