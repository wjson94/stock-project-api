package com.wjproject.stockproject.auth.controller;

import com.wjproject.stockproject.auth.dto.request.LoginRequest;
import com.wjproject.stockproject.auth.dto.response.LoginResponse;
import com.wjproject.stockproject.auth.service.AuthService;
import com.wjproject.stockproject.global.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth API")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Operation(summary = "로그인")
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(@RequestBody LoginRequest request) {
        LoginResponse response = authService.login(request);
        return ResponseEntity.ok(ApiResponse.success(response, request.getUserId()));
    }
}
