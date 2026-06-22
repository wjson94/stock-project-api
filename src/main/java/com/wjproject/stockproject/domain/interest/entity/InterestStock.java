package com.wjproject.stockproject.domain.interest.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "tb_interest_stock", schema = "public")
public class InterestStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interest_stock_seq")
    private Long interestStockSeq;

    @Column(name = "user_seq")
    private Long userSeq;

    @Column(name = "stock_code", nullable = false, length = 10)
    private String stockCode;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Builder
    private InterestStock(Long userSeq, String stockCode) {
        this.userSeq = userSeq;
        this.stockCode = stockCode;
        this.createdAt = LocalDateTime.now();
    }
}
