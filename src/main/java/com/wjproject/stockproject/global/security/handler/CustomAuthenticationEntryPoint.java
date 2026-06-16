package com.wjproject.stockproject.global.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wjproject.stockproject.global.common.logging.ErrorLogger;
import com.wjproject.stockproject.global.common.response.ApiResponse;
import com.wjproject.stockproject.global.common.response.ErrorCode;
import com.wjproject.stockproject.global.common.response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ErrorLogger errorLogger;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException e) throws IOException {

        errorLogger.error(request, HttpStatus.UNAUTHORIZED, e);

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json;charset=UTF-8");

        ApiResponse<Void> apiResponse =
                ApiResponse.fail(
                        ErrorResponse.of(ErrorCode.STOCK_UNAUTHORIZED)
                );

        response.getWriter().write(
                objectMapper.writeValueAsString(apiResponse)
        );
    }
}
