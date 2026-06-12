package com.wjproject.stockproject.trend.websocket;

import com.wjproject.stockproject.trend.dto.response.TrendResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrendWebSocketPublisher {

    private final SimpMessagingTemplate messagingTemplate;

    public void publish(TrendResponse response) {
        messagingTemplate.convertAndSend(
                "/topic/trend",
                response
        );
    }
}
