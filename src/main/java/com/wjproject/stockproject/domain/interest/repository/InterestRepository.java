package com.wjproject.stockproject.domain.interest.repository;

import com.wjproject.stockproject.domain.interest.entity.InterestStock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterestRepository extends JpaRepository<InterestStock, Long> {

    List<InterestStock> findAllByUserSeqOrderByCreatedAtDesc(Long userSeq);

    boolean existsByUserSeqAndStockCode(Long userSeq, String stockCode);

    int deleteByUserSeqAndStockCode(Long userSeq, String stockCode);
}
