package com.capgemini.wsb.fitnesstracker.statistics.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/statistics")
public class StatisticsController {
    @Autowired
    private StatisticsServiceImpl statisticsService;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Long> deleteStatistic(@PathVariable Long id) {
        statisticsService.deleteStatistic(id);
        return ResponseEntity.ok(id);
    }
}
