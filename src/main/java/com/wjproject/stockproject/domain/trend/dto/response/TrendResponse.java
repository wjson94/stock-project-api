package com.wjproject.stockproject.domain.trend.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TrendResponse {

    private String stockCode;

    private String stockName;

    private Integer currentPrice;

    private Double changeRate;
}
