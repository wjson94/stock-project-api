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
import org.springframework.http.HttpStatus;
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

    @Operation(summary = "관심 종목 추가")
    @PostMapping("/interest")
    public ResponseEntity<ApiResponse<Void>> addInterestStock(
            @AuthenticationPrincipal CustomUserDetails user,
            @RequestBody InterestStockRequest request) {

        interestService.addInterestStock(user.getUserSeq(), request.getStockCode());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.created());
    }

    @Operation(summary = "관심 종목 삭제")
    @DeleteMapping("/interest/{stockCode}")
    public ResponseEntity<ApiResponse<Void>> removeInterestStock(
            @AuthenticationPrincipal CustomUserDetails user,
            @PathVariable String stockCode
    ) {

        interestService.removeInterestStock(user.getUserSeq(), stockCode);

        return ResponseEntity.ok(ApiResponse.success());
    }
}
