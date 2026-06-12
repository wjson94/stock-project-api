package com.wjproject.stockproject.trend.service;

import com.wjproject.stockproject.trend.dto.response.TrendResponse;
import com.wjproject.stockproject.trend.dummy.TrendDummyGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrendService {

    private final TrendDummyGenerator trendDummyGenerator;

    public TrendResponse getTrend() {

        return trendDummyGenerator.generate();

    }
}
