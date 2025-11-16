package com.finsight.app.controller;

import com.finsight.app.model.User;
import com.finsight.app.service.AnalyticsService;
import com.finsight.app.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/api/analytics")
@CrossOrigin
public class AnalyticsController {

    private final AnalyticsService analyticsService;
    private final UserService userService;

    public AnalyticsController(AnalyticsService analyticsService,
                               UserService userService) {
        this.analyticsService = analyticsService;
        this.userService = userService;
    }

    private User getUserOrThrow(Long userId) {
        return userService.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @GetMapping("/summary")
    public ResponseEntity<Map<String, Object>> getSummary(@RequestParam Long userId) {
        User user = getUserOrThrow(userId);
        return ResponseEntity.ok(analyticsService.getSummary(user));
    }

    @GetMapping("/by-category")
    public ResponseEntity<Map<String, BigDecimal>> getByCategory(@RequestParam Long userId) {
        User user = getUserOrThrow(userId);
        return ResponseEntity.ok(analyticsService.getSpendingByCategory(user));
    }
}
