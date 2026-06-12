package com.wjproject.stockproject.global.common.response;

import lombok.Getter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class MetaResponse {

    private final String timestamp;

    private MetaResponse() {
        this.timestamp = ZonedDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX"));
    }

    public static MetaResponse of() {
        return new MetaResponse();
    }
}