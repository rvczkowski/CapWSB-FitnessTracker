package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import com.capgemini.wsb.fitnesstracker.user.api.UserProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrainingMapper {
    @Autowired
    private UserProvider userProvider;

    public TrainingDto toDto(Training training) {
        return new TrainingDto(training.getId(), training.getUser().getId(), training.getStartTime(), training.getEndTime(), training.getActivityType(),
                training.getDistance(), training.getCalories());
    }

    public Training toEntity(TrainingDto trainingDto) {
        return new Training(userProvider.getUser(trainingDto.getUserId()).get(), trainingDto.getStartTime(), trainingDto.getEndTime(), trainingDto.getActivityType(),
                trainingDto.getDistance(), trainingDto.getCalories());
    }
}
