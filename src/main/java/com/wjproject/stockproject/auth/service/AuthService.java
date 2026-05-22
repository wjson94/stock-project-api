package com.wjproject.stockproject.auth.service;

import com.wjproject.stockproject.auth.dto.request.LoginRequest;
import com.wjproject.stockproject.auth.dto.response.LoginResponse;
import com.wjproject.stockproject.global.security.jwt.JwtTokenProvider;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final JwtTokenProvider jwtTokenProvider;

    public AuthService(
            JwtTokenProvider jwtTokenProvider
    ) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public LoginResponse login(
            LoginRequest request
    ) {

        // 실제로는 DB 조회 + 비밀번호 검증
        if (!request.getId().equals("ohjr008")) {
            throw new RuntimeException("회원 없음");
        }

        if (!request.getPassword().equals("1234")) {
            throw new RuntimeException("비밀번호 오류");
        }

        String token =
                jwtTokenProvider.createToken(
                        request.getId()
                );

        return new LoginResponse(token);
    }
}
