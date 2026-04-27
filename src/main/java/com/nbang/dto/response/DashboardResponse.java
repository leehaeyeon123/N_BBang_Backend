package com.nbang.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardResponse {
    private Summary summary;
    private List<CategoryStat> categoryStats;
    private List<MonthlyStat> monthlyStats;
    private List<RecentExpense> recentExpenses;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Summary {
        private long totalExpense;
        private long myShare;
        private long unsettledReceivable;
        private long unsettledPayable;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CategoryStat {
        private String category;
        private long amount;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MonthlyStat {
        private String month;
        private long amount;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RecentExpense {
        private String title;
        private long amount;
        private String category;
        private String date;
    }
}