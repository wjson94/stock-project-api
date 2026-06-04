package com.wjproject.stockproject.global.common.exception;

import com.wjproject.stockproject.global.common.response.ApiResponse;
import com.wjproject.stockproject.global.common.response.ErrorCode;
import com.wjproject.stockproject.global.common.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 커스텀 예외
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiResponse<Void>> handleCustomException(CustomException e) {
        ErrorCode errorCode = e.getErrorCode();
        return ResponseEntity
                .status(errorCode.getStatus())
                .body(ApiResponse.fail(ErrorResponse.of(errorCode)));
    }

    // 예상치 못한 예외
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleException(Exception e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.fail(ErrorResponse.of(ErrorCode.STOCK_SERVER_ERROR)));
    }
}