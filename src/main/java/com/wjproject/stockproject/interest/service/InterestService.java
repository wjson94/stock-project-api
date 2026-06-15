package com.wjproject.stockproject.interest.service;

import com.wjproject.stockproject.global.common.exception.CustomException;
import com.wjproject.stockproject.global.common.response.ErrorCode;
import com.wjproject.stockproject.interest.entity.InterestStock;
import com.wjproject.stockproject.interest.repository.InterestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InterestService {

    private final InterestRepository interestRepository;

    public void addInterestStock(Long userSeq, String stockCode) {

        if (interestRepository.existsByUserSeqAndStockCode(userSeq, stockCode)) {
            throw new CustomException(ErrorCode.STOCK_DUPLICATE_INTEREST);
        }

        InterestStock interestStock = InterestStock.builder()
                .userSeq(userSeq)
                .stockCode(stockCode)
                .build();

        interestRepository.save(interestStock);
    }
}
