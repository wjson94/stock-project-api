package com.wjproject.stockproject.auth.service;

import com.wjproject.stockproject.auth.dto.request.LoginRequest;
import com.wjproject.stockproject.auth.dto.response.LoginResponse;
import com.wjproject.stockproject.auth.entity.User;
import com.wjproject.stockproject.auth.repository.UserRepository;
import com.wjproject.stockproject.global.common.exception.CustomException;
import com.wjproject.stockproject.global.common.response.ErrorCode;
import com.wjproject.stockproject.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginResponse login(
            LoginRequest request
    ) {

        User user = userRepository.findByUserId(request.getUserId())
                .orElseThrow(() -> new CustomException(ErrorCode.STOCK_LOGIN_FAILED));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new CustomException(ErrorCode.STOCK_LOGIN_FAILED);
        }

        String token = jwtTokenProvider.createToken(user.getUserId());

        return new LoginResponse(token);
    }
}
