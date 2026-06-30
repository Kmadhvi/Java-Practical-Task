package com.expense_management.repository;

import com.expense_management.entity.ExpenseShare;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseShareRepository extends JpaRepository<ExpenseShare,Long> {
    List<ExpenseShare> findByExpenseId(Long expenseId);
}
