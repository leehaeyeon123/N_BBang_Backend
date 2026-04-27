package com.nbang;

import com.nbang.domain.entity.Settlement;
import com.nbang.domain.repository.ExpenseShareRepository;
import com.nbang.domain.repository.SettlementRepository;
import com.nbang.dto.response.SettlementSummaryResponse;
import com.nbang.exception.BusinessException;
import com.nbang.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SettlementService {

    private final ExpenseShareRepository expenseShareRepository;
    private final SettlementRepository settlementRepository;

    @Transactional(readOnly = true)
    public List<SettlementSummaryResponse> getSummary(String houseId, String userId) {
        // 우선 빈 리스트 반환하여 컴파일 에러 해결
        return new ArrayList<>();
    }

    @Transactional
    public void requestSettlement(String houseId, String fromUserId, String toUserId, long amount) {
        Settlement settlement = Settlement.builder()
                .houseId(houseId)
                .fromUserId(fromUserId)
                .toUserId(toUserId)
                .amount(amount)
                .status(Settlement.Status.PENDING)
                .build();
        settlementRepository.save(settlement);
    }
}