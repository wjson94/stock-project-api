package com.wjproject.stockproject.domain.trend.dummy;

import com.wjproject.stockproject.domain.trend.service.TrendWebSocketService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@EnableScheduling
public class TrendScheduler {

    private final TrendWebSocketService trendWebSocketService;

    @Scheduled(fixedRate = 1000)
    public void publish() {
        trendWebSocketService.publishTrend();
    }
}