package com.wjproject.stockproject.global.common.response;

import lombok.Getter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class MetaResponse {

    private final String timestamp;
    private final String requestId;

    private MetaResponse(String requestId) {
        this.timestamp = ZonedDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX"));
        this.requestId = requestId;
    }

    public static MetaResponse requestId(String requestId) {
        return new MetaResponse(requestId);
    }
}