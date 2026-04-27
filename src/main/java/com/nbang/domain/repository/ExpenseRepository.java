package com.nbang.domain.repository;

import com.nbang.domain.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    // 에러가 났던 sumAmountByHouseAndMonth 메서드를 제거하거나 
    // 아래와 같이 기본 제공 메서드로 대체합니다.
    List<Expense> findByHouseId(String houseId);
}