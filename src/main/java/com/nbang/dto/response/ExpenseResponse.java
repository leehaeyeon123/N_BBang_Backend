package com.nbang.dto.response;

import lombok.*;
import java.util.List;

@Getter @Builder @NoArgsConstructor @AllArgsConstructor
public class ExpenseResponse {
    private Long id;
    private String title;
    private long amount;
    private String category;
    private String paidBy;
    private List<ShareResponse> shares;

    @Getter @Builder @NoArgsConstructor @AllArgsConstructor
    public static class ShareResponse {
        private String userId;
        private long amount;
    }
}