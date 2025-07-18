package com.example.jpa.component;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private long expireTime = 1000 * 60 * 60;

    public String createToken(String username) {
        return Jwts.builder()
                .setSubject(username) // id 넣어서 만듦
                .setIssuedAt((new Date()))
                .setExpiration(new Date(System.currentTimeMillis() + expireTime))
                .signWith(key)
                .compact();
    }

    public static Boolean validate(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build()
                    .parseClaimsJws(token);
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public String getUsername(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build()
                .parseClaimsJws(token) //토큰 분석
                .getBody() // clasims: 전문 수입
                .getSubject(); // << 그래서 여기 id 들어 있음
    }
}
