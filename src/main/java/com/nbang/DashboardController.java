package com.nbang;

import com.nbang.dto.response.DashboardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = {
  "http://localhost:3000",
  "http://localhost:5173",
  "https://n-b-bang-frontend.vercel.app/"
})
public class DashboardController {

    private final DashboardService dashboardService;

    // 대시보드 데이터 조회
    @GetMapping("/houses/{houseId}/dashboard")
    public DashboardResponse getDashboard(
            @PathVariable String houseId,
            @RequestParam String userId,
            @RequestParam(required = false) String month) {
        return dashboardService.getDashboard(houseId, userId, month);
    }

    // 지출 저장 (새로 추가되는 부분)
    @PostMapping("/houses/{houseId}/expenses")
    public void addExpense(
            @PathVariable String houseId,
            @RequestBody Map<String, Object> payload) {
        dashboardService.saveExpense(houseId, payload);
    }
}