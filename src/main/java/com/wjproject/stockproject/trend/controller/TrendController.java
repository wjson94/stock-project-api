package com.wjproject.stockproject.trend.controller;

import com.wjproject.stockproject.global.security.principal.CustomUserDetails;
import com.wjproject.stockproject.interest.dto.request.InterestStockRequest;
import com.wjproject.stockproject.interest.service.InterestService;
import com.wjproject.stockproject.trend.dto.response.TrendResponse;
import com.wjproject.stockproject.trend.service.TrendService;
import com.wjproject.stockproject.global.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/trend")
@Tag(name = "Trend API")
public class TrendController {

    private final TrendService trendService;
    private final InterestService interestService;

    @Operation(summary = "트렌드 메뉴")
    @GetMapping
    public ResponseEntity<ApiResponse<TrendResponse>> getTrend(/*@RequestBody TrendRequest request*/) {

        TrendResponse response = trendService.getTrend();

        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @Operation(summary = "관심 종목 등록")
    @PostMapping("/interest")
    public ResponseEntity<ApiResponse<Void>> addInterestStock(@AuthenticationPrincipal CustomUserDetails user, @RequestBody InterestStockRequest request) {

        interestService.addInterestStock(user.getUserSeq(), request.getStockCode());

        return ResponseEntity.ok(ApiResponse.created());
    }
}
