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
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private final ErrorLogger errorLogger;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException e) throws IOException {

        errorLogger.error(request, HttpStatus.FORBIDDEN, e);

        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType("application/json;charset=UTF-8");

        ApiResponse<Void> apiResponse =
                ApiResponse.fail(
                        ErrorResponse.of(ErrorCode.STOCK_FORBIDDEN)
                );

        response.getWriter().write(
                objectMapper.writeValueAsString(apiResponse)
        );
    }
}