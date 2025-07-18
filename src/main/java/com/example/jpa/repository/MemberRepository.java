package com.example.jpa.repository;

import com.example.jpa.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// DB와 직접 통신하진 않고, Spring Data JPA가 자동으로 구현체를 만듦
public interface MemberRepository extends JpaRepository<MemberEntity, Long> { //<>제네릭 타입 맞춰 줘야 하미  long Id 같은 거
    // <MemberEntity, Long>: 어떤 entity를 다룰지 설정, ID, 즉 기본키의 타입.
    // findAll(), findById(), save(), delete() 등 기본 CRUD 메서드는 자동 생성시켜 줌.
    Optional<MemberEntity> findByUsername(String username);
}
