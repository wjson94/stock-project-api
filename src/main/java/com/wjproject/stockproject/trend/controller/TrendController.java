package com.wjproject.stockproject.trend.controller;

import com.wjproject.stockproject.trend.dto.response.TrendResponse;
import com.wjproject.stockproject.trend.service.TrendService;
import com.wjproject.stockproject.global.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/trend")
@Tag(name = "Trend API")
public class TrendController {

    private final TrendService trendService;

    @Operation(summary = "트렌드 메뉴")
    @GetMapping
    public ResponseEntity<ApiResponse<TrendResponse>> getTrend(/*@RequestBody TrendRequest request*/) {

        TrendResponse response = trendService.getTrend();

        return ResponseEntity.ok(ApiResponse.success(response));
    }
}
