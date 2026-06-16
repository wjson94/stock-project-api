package com.wjproject.stockproject.interest.dto.response;

import com.wjproject.stockproject.interest.entity.InterestStock;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InterestStockResponse {

    private String stockCode;

    public static InterestStockResponse from(InterestStock entity) {
        return new InterestStockResponse(entity.getStockCode());
    }
}
