package com.nbang;

import com.nbang.domain.entity.Expense;
import com.nbang.domain.entity.ExpenseShare;
import com.nbang.domain.repository.ExpenseRepository;
import com.nbang.domain.repository.ExpenseShareRepository;
import com.nbang.dto.request.ExpenseCreateRequest;
import com.nbang.dto.response.ExpenseResponse;
import com.nbang.exception.BusinessException;
import com.nbang.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ExpenseShareRepository expenseShareRepository;

    @Transactional
    public ExpenseResponse createExpense(String houseId, String userId, ExpenseCreateRequest req) {
        Expense expense = Expense.builder()
                .houseId(houseId)
                .title(req.getTitle())
                .amount(req.getAmount())
                .category(req.getCategory())
                .paidBy(userId)
                .build();
        
        expenseRepository.save(expense);

        List<ExpenseShare> shares = new ArrayList<>();
        if (req.getMemberIds() != null) {
            for (String memberId : req.getMemberIds()) {
                shares.add(ExpenseShare.builder()
                        .houseId(houseId)
                        .userId(memberId)
                        .shareAmount(expense.getAmount() / req.getMemberIds().size())
                        .settled(false)
                        .build());
            }
        }
        expenseShareRepository.saveAll(shares);

        return ExpenseResponse.builder()
                .id(expense.getId())
                .title(expense.getTitle())
                .amount(expense.getAmount())
                .build();
    }
}