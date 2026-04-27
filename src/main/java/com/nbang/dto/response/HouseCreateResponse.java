package com.nbang.dto.response;

import lombok.*;

@Getter @Builder @NoArgsConstructor @AllArgsConstructor
public class HouseCreateResponse {
    private String houseId;
    private String name;
    private String inviteCode;
}