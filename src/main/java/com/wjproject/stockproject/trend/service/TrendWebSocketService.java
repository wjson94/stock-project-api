package com.wjproject.stockproject.trend.service;

import com.wjproject.stockproject.trend.dto.response.TrendResponse;
import com.wjproject.stockproject.trend.dummy.TrendDummyGenerator;
import com.wjproject.stockproject.trend.websocket.TrendWebSocketPublisher;
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
