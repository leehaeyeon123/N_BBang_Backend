package com.nbang.dto.response;

import lombok.*;

@Getter @Builder @NoArgsConstructor @AllArgsConstructor
public class SettlementSummaryResponse {
    private String senderId;
    private String receiverId;
    private long amount;
    private String status;
}