package com.capgemini.wsb.fitnesstracker.statistics.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class StatisticsServiceImpl {
    @Autowired
    private StatisticsRepository statisticsRepository;

    public void deleteStatistic(Long id) {
        statisticsRepository.deleteById(id);
    }
}
