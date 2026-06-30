package com.expense_management.controller;

import com.expense_management.dto.CreateExpenseRequest;
import com.expense_management.entity.Expense;
import com.expense_management.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trip-groups")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping("/{tripGroupId}/expenses")
    public Expense createExpense(
            @PathVariable Long tripGroupId,
            @RequestBody CreateExpenseRequest request){

        return expenseService.createExpense(
                tripGroupId,
                request);

    }

    @GetMapping("/{tripGroupId}/expenses")
    public List<Expense> getExpenses(
            @PathVariable Long tripGroupId){

        return expenseService.getExpenses(tripGroupId);

    }

}
