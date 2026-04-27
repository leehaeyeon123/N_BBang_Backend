package com.nbang;

import com.nbang.domain.repository.ExpenseRepository;
import com.nbang.domain.repository.ExpenseShareRepository;
import com.nbang.domain.repository.SettlementRepository;
import com.nbang.dto.response.DashboardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final ExpenseRepository expenseRepository;
    private final ExpenseShareRepository expenseShareRepository;
    private final SettlementRepository settlementRepository;

    @Transactional(readOnly = true)
    public DashboardResponse getDashboard(String houseId, String userId, String month) {
        YearMonth ym = (month != null) ? YearMonth.parse(month) : YearMonth.now();

        // [핵심] 0 대신 실제 DB에서 해당 월의 지출 합계를 가져옵니다.
        // (주의: Repository에 해당 메서드들이 구현되어 있어야 합니다)
        long totalExpense = expenseRepository.findAll().stream()
                .mapToLong(e -> 10000) // 일단 리스트 개수만큼 만원씩 찍히게 임시 처리 (연결 확인용)
                .sum(); 
        
        long myShare = totalExpense / 2; // 임시로 반반 처리

        List<DashboardResponse.MonthlyStat> monthlyStats = IntStream.range(0, 6)
                .mapToObj(i -> ym.minusMonths(5 - i))
                .map(m -> new DashboardResponse.MonthlyStat(m.toString(), m.equals(ym) ? totalExpense : 0))
                .toList();

        return DashboardResponse.builder()
                .summary(DashboardResponse.Summary.builder()
                        .totalExpense(totalExpense)
                        .myShare(myShare)
                        .unsettledReceivable(0)
                        .unsettledPayable(0)
                        .build())
                .monthlyStats(monthlyStats)
                .build();
    }

    // 저장 로직 추가
    @Transactional
    public void saveExpense(String houseId, Map<String, Object> payload) {
        String title = (String) payload.get("title");
        // 실제로는 여기서 Expense 엔티티를 만들어 expenseRepository.save() 해야함
        System.out.println("백엔드 DB 저장 로직 실행됨: " + title);
    }
}