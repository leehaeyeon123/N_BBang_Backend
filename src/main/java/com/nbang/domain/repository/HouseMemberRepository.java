package com.nbang.domain.repository;

import com.nbang.domain.entity.HouseMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface HouseMemberRepository extends JpaRepository<HouseMember, Long> {
    Optional<HouseMember> findByHouseIdAndUserId(String houseId, String userId);
}