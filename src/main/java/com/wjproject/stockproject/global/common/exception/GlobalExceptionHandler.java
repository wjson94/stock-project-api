package com.wjproject.stockproject.global.common.exception;

import com.wjproject.stockproject.global.common.logging.ErrorLogger;
import com.wjproject.stockproject.global.common.response.ApiResponse;
import com.wjproject.stockproject.global.common.response.ErrorCode;
import com.wjproject.stockproject.global.common.response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class GlobalExceptionHandler {

    private final ErrorLogger errorLogger;

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiResponse<Void>> handleCustomException(
            HttpServletRequest request,
            CustomException e) {

        ErrorCode errorCode = e.getErrorCode();

        errorLogger.error(request, HttpStatusCode.valueOf(errorCode.getStatus()), e);

        return ResponseEntity
                .status(errorCode.getStatus())
                .body(ApiResponse.fail(ErrorResponse.of(errorCode)));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleException(
            HttpServletRequest request,
            Exception e) {

        errorLogger.error(request, HttpStatus.INTERNAL_SERVER_ERROR, e);

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.fail(ErrorResponse.of(ErrorCode.STOCK_SERVER_ERROR)));
    }
}