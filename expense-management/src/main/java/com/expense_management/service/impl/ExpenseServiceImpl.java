package com.expense_management.service.impl;

import com.expense_management.dto.CreateExpenseRequest;
import com.expense_management.entity.*;
import com.expense_management.repository.*;
import com.expense_management.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    private final ExpenseShareRepository expenseShareRepository;

    private final MemberRepository memberRepository;

    private final TripGroupRepository tripGroupRepository;

    @Override
    public Expense createExpense(Long tripGroupId,
                                 CreateExpenseRequest request) {

        TripGroup tripGroup = tripGroupRepository.findById(tripGroupId)
                .orElseThrow(() ->
                        new RuntimeException("Trip Group not found"));

        Member paidBy = memberRepository.findById(request.getPaidBy())
                .orElseThrow(() ->
                        new RuntimeException("Member not found"));

        Expense expense = Expense.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .amount(request.getAmount())
                .expenseDate(LocalDate.now())
                .paidBy(paidBy)
                .tripGroup(tripGroup)
                .build();

        expense = expenseRepository.save(expense);

        BigDecimal share =
                request.getAmount().divide(
                        BigDecimal.valueOf(request.getParticipants().size()),
                        2,
                        RoundingMode.HALF_UP);

        for (Long memberId : request.getParticipants()) {

            Member member = memberRepository.findById(memberId)
                    .orElseThrow(() ->
                            new RuntimeException("Member not found"));

            ExpenseShare expenseShare = ExpenseShare.builder()
                    .expense(expense)
                    .member(member)
                    .shareAmount(share)
                    .build();

            expenseShareRepository.save(expenseShare);

        }

        return expense;

    }

    @Override
    public List<Expense> getExpenses(Long tripGroupId) {

        return expenseRepository.findByTripGroupId(tripGroupId);

    }

}