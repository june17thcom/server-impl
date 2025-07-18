package com.example.jpa.controller;

import com.example.jpa.component.JwtTokenProvider;
import com.example.jpa.dto.loginRequestDTO;
import com.example.jpa.entity.MemberEntity;
import com.example.jpa.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController //Json으로 주고 받음
@RequestMapping("/api/member")
public class MemberController {

    private final BCryptPasswordEncoder encoder;
    private final MemberService memberService;
    private final JwtTokenProvider jwtTokenProvider;

    public MemberController(BCryptPasswordEncoder encoder, MemberService memberService, JwtTokenProvider jwtTokenPrivider) {
        this.encoder = encoder;
        this.memberService = memberService;
        this.jwtTokenProvider = jwtTokenPrivider;
    }

    @PostMapping("/register")
    public String register(@RequestBody MemberEntity member) {
        System.out.println("회원가입 시도" + member);
        member.setPassword(encoder.encode(member.getPassword()));
        memberService.save(member);
        return "회원가입 완료";
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody loginRequestDTO dto) {
        try{
            MemberEntity member = memberService.findByUsername(dto.getUsername());
            if(!encoder.matches(dto.getPassword(), member.getPassword())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("아이디 또는 비밀번호 오류");
            }
            String token = jwtTokenProvider.createToken(member.getUsername());
            return ResponseEntity.ok(token);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
        }
    }

    @GetMapping("/me")
    public ResponseEntity<MemberEntity> getMember(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        String username = jwtTokenProvider.getUsername(token);
        MemberEntity member = memberService.findByUsername(username);
        return ResponseEntity.ok(member);
    }

    @PutMapping("/update")
    public String update(@RequestBody MemberEntity member, @RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        String username = jwtTokenProvider.getUsername(token);
        memberService.update(username, member.getName(), encoder.encode(member.getPassword()));
        return "정보 수정 완료";
    }
}
