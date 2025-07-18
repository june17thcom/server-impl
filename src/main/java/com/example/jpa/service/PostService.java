package com.example.jpa.service;

import com.example.jpa.dto.PostResponseDTO;
import com.example.jpa.repository.PostRepository;
import com.example.jpa.entity.MemberEntity;
import com.example.jpa.entity.PostEntity;
import com.example.jpa.repository.MemberRepository;
import com.example.jpa.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final MemberRepository memberRepository;
    private static PostRepository postRepository;

    public PostService(MemberRepository memberRepository, PostRepository postRepository) {
        this.memberRepository = memberRepository;
        PostService.postRepository = postRepository;
    }

    public void write(String username, String title, String content){
        MemberEntity writer = memberRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("사용자 없음"));
        PostEntity post = new PostEntity();
        post.setTitle(title);
        post.setContent(content);
        post.setWriter(writer);
        postRepository.save(post);
    }

    public  List<PostResponseDTO> findAll(){
        return postRepository.findAll().stream().map(PostResponseDTO::new).collect(Collectors.toList());
    }
}