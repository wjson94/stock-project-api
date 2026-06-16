package com.wjproject.stockproject.interest.service;

import com.wjproject.stockproject.global.common.exception.CustomException;
import com.wjproject.stockproject.global.common.response.ErrorCode;
import com.wjproject.stockproject.interest.dto.response.InterestStockListResponse;
import com.wjproject.stockproject.interest.entity.InterestStock;
import com.wjproject.stockproject.interest.repository.InterestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InterestService {

    private final InterestRepository interestRepository;

    public InterestStockListResponse getInterestStocks(Long userSeq) {

        List<InterestStock> interestStocks =
                interestRepository.findAllByUserSeqOrderByCreatedAtDesc(userSeq);

        return InterestStockListResponse.from(interestStocks);
    }

    @Transactional
    public void addInterestStock(Long userSeq, String stockCode) {

        if (interestRepository.existsByUserSeqAndStockCode(userSeq, stockCode)) {
            throw new CustomException(ErrorCode.STOCK_DUPLICATE);
        }

        InterestStock interestStock = InterestStock.builder()
                .userSeq(userSeq)
                .stockCode(stockCode)
                .build();

        interestRepository.save(interestStock);
    }

    @Transactional
    public void removeInterestStock(Long userSeq, String stockCode) {

        int deleteCount = interestRepository.deleteByUserSeqAndStockCode(userSeq, stockCode);

        if (deleteCount == 0) {
            throw new CustomException(ErrorCode.STOCK_NOT_FOUND);
        }
    }
}
