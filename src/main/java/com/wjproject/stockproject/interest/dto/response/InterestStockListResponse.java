package com.wjproject.stockproject.interest.dto.response;

import com.wjproject.stockproject.interest.entity.InterestStock;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class InterestStockListResponse {

    private List<InterestStockResponse> interestStocks;

    public static InterestStockListResponse from(List<InterestStock> entities) {

        List<InterestStockResponse> interestStocks = entities.stream()
                .map(InterestStockResponse::from)
                .toList();

        return InterestStockListResponse.builder()
                .interestStocks(interestStocks)
                .build();
    }
}
