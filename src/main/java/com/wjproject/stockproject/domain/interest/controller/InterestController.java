package com.wjproject.stockproject.domain.interest.controller;

import com.wjproject.stockproject.global.common.response.ApiResponse;
import com.wjproject.stockproject.global.security.principal.CustomUserDetails;
import com.wjproject.stockproject.domain.interest.dto.response.InterestStockListResponse;
import com.wjproject.stockproject.domain.interest.service.InterestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/interest")
@Tag(name = "Interest API")
public class InterestController {

    private final InterestService interestService;

    @Operation(summary = "관심 종목 조회")
    @GetMapping
    public ResponseEntity<ApiResponse<InterestStockListResponse>> getInterestStocks(
            @AuthenticationPrincipal CustomUserDetails user) {

        InterestStockListResponse response =
                interestService.getInterestStocks(user.getUserSeq());

        return ResponseEntity.ok(ApiResponse.success(response));
    }
}
