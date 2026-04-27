package com.nbang.dto.request;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter @Setter
public class ExpenseCreateRequest {
    private String title;
    private long amount;
    private String category;
    private String splitMethod; // EQUAL, RATIO, CUSTOM
    private List<ShareItem> shares;
    private List<String> memberIds;

    @Getter @Setter
    public static class ShareItem {
        private String userId;
        private int ratio;
        private long amount;
    }
}