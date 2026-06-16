package com.wjproject.stockproject.global.common.logging;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ErrorLogger {

    public void error(HttpServletRequest request, HttpStatusCode errorCode, Exception e) {

        log.error(
                "[{}] [{}] [{}] - {}",
                request.getMethod(),
                errorCode,
                request.getRequestURI(),
                e.getMessage(),
                e
        );
    }
}
