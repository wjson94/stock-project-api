package com.wjproject.stockproject.interest.repository;

import com.wjproject.stockproject.interest.entity.InterestStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestRepository extends JpaRepository<InterestStock, Long> {

    boolean existsByUserSeqAndStockCode(
            Long userSeq,
            String stockCode
    );
}
