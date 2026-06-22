package com.wjproject.stockproject.domain.trend.dummy;

import com.wjproject.stockproject.domain.trend.dto.response.TrendResponse;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class TrendDummyGenerator {

    private final Random random = new Random();

    public TrendResponse generate() {

        return TrendResponse.builder()
                .stockCode("005930")
                .stockName("삼성전자")
                .currentPrice(80000 + random.nextInt(1000))
                .changeRate(random.nextDouble() * 5)
                .build();
    }
}