package com.expense_management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BalanceResponse {

    private Long memberId;

    private String memberName;

    private BigDecimal paid;

    private BigDecimal share;

    private BigDecimal balance;
}
