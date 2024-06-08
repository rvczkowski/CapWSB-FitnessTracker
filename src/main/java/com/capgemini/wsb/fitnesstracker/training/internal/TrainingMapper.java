package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import org.springframework.stereotype.Component;

@Component
public class TrainingMapper {

    public TrainingDto toDto(Training training) {
        return new TrainingDto(training.getId(), training.getActivityType(), training.getDate(), training.getDuration(),
                training.getDistance(), training.setDistance(), training.getUserId());
    }

    public Training toEntity(TrainingDto trainingDto) {
        return new Training(trainingDto.getActivityType(), trainingDto.getDate(), trainingDto.getDuration(),
                trainingDto.getDistance(), trainingDto.setDistance(), trainingDto.getUserId());
    }
}
