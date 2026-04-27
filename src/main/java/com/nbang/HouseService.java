package com.nbang;

import com.nbang.domain.entity.House;
import com.nbang.domain.entity.HouseMember;
import com.nbang.domain.repository.HouseMemberRepository;
import com.nbang.domain.repository.HouseRepository;
import com.nbang.dto.response.HouseCreateResponse;
import com.nbang.exception.BusinessException;
import com.nbang.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HouseService {

    private final HouseRepository houseRepository;
    private final HouseMemberRepository houseMemberRepository;

    @Transactional
    public HouseCreateResponse createHouse(String userId, String houseName) {
        String houseId = UUID.randomUUID().toString();
        String inviteCode = UUID.randomUUID().toString().substring(0, 8);

        House house = House.builder()
                .houseId(houseId)
                .name(houseName)
                .inviteCode(inviteCode)
                .build();
        houseRepository.save(house);

        HouseMember owner = HouseMember.builder()
                .houseId(houseId)
                .userId(userId)
                .role(HouseMember.Role.OWNER)
                .build();
        houseMemberRepository.save(owner);

        return HouseCreateResponse.builder()
                .houseId(houseId)
                .name(houseName)
                .inviteCode(inviteCode)
                .build();
    }
}