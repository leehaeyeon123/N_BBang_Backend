package com.nbang.domain.repository;

import com.nbang.domain.entity.ExpenseShare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ExpenseShareRepository extends JpaRepository<ExpenseShare, Long> {
    List<ExpenseShare> findByHouseId(String houseId);
    List<ExpenseShare> findByHouseIdAndUserId(String houseId, String userId);
}