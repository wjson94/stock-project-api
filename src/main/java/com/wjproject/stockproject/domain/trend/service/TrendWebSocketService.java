package com.wjproject.stockproject.domain.trend.service;

import com.wjproject.stockproject.domain.trend.dto.response.TrendResponse;
import com.wjproject.stockproject.domain.trend.dummy.TrendDummyGenerator;
import com.wjproject.stockproject.domain.trend.websocket.TrendWebSocketPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrendWebSocketService {
    private final TrendDummyGenerator trendDummyGenerator;
    private final TrendWebSocketPublisher publisher;

    public void publishTrend() {

        TrendResponse response = trendDummyGenerator.generate();

        publisher.publish(response);
    }
}
