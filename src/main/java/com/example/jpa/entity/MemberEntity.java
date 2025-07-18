package com.example.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "member")
public class MemberEntity {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private Long id;

    @Column(nullable = false, unique = true) // column 어노테이션 뒤엔 거의 =부호 들어간 sql 문법.
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false)
    private String name;

    public MemberEntity() {}

    public MemberEntity(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }
}
