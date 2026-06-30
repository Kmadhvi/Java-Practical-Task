package com.expense_management.service;

import com.expense_management.dto.CreateExpenseRequest;
import com.expense_management.entity.Expense;

import java.util.List;

public interface ExpenseService {

    Expense createExpense(Long tripGroupId,
                          CreateExpenseRequest request);

    List<Expense> getExpenses(Long tripGroupId);

}
