package com.expense_management.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


@Data
public class CreateExpenseRequest {

    private String title;

    private BigDecimal amount;

    private Long paidBy;

    private List<Long> participants;

    private String description;

}
