package com.wjproject.stockproject.global.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private final Key key;

    public JwtTokenProvider(
            @Value("${jwt.secret}") String secretKey
    ) {
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public String createToken(String email) {

        Date now = new Date();

        Date expire = new Date(
                now.getTime() + 1000 * 60 * 60
        );

        return Jwts.builder()
                .subject(email)
                .issuedAt(now)
                .expiration(expire)
                .signWith(key)
                .compact();
    }

    public String getEmail(String token) {

        return Jwts.parser()
                .verifyWith((javax.crypto.SecretKey) key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean validate(String token) {

        try {

            Jwts.parser()
                    .verifyWith((javax.crypto.SecretKey) key)
                    .build()
                    .parseSignedClaims(token);

            return true;

        } catch (Exception e) {
            return false;
        }
    }
}