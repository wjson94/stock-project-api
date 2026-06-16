package com.wjproject.stockproject.global.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    STOCK_BAD_REQUEST("STOCK_BAD_REQUEST", "잘못된 요청입니다.", 400),
    STOCK_LOGIN_FAILED("STOCK_LOGIN_FAILED", "아이디 또는 비밀번호가 올바르지 않습니다.", 401),
    STOCK_UNAUTHORIZED("STOCK_UNAUTHORIZED", "인증이 필요합니다.", 401),
    STOCK_FORBIDDEN("STOCK_FORBIDDEN", "엑세스 권한이 없습니다.", 403),
    STOCK_NOT_FOUND("STOCK_NOT_FOUND", "요청된 리소스를 찾을 수 없습니다.", 404),
    STOCK_DUPLICATE("STOCK_DUPLICATE", "중복된 요청입니다.", 409),
    STOCK_SERVER_ERROR("STOCK_SERVER_ERROR", "서버 오류가 발생했습니다.", 500);

    private final String code;
    private final String message;
    private final int status;
}