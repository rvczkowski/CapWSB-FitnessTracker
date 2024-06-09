package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import com.capgemini.wsb.fitnesstracker.user.api.UserProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingServiceImpl {

    @Autowired
    private TrainingRepository trainingRepository;

    @Autowired
    private TrainingMapper trainingMapper;
    @Autowired
    private UserProvider userProvider;

    public TrainingDto createTraining(TrainingDto trainingDto) {
        Training training = trainingMapper.toEntity(trainingDto);
        training = trainingRepository.save(training);
        return trainingMapper.toDto(training);
    }

    public List<TrainingDto> getAllTrainings() {
        return trainingRepository.findAll().stream()
                .map(trainingMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<TrainingDto> getTrainingsByUserId(Long userId) {
        User user = userProvider.getUser(userId).get();
        return trainingRepository.findByUser(user).stream()
                .map(trainingMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<TrainingDto> getCompletedTrainings(Date date) {
        return trainingRepository.findByStartTimeBefore(date).stream()
                .map(trainingMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<TrainingDto> getTrainingsByActivityType(ActivityType activityType) {
        return trainingRepository.findByActivityType(activityType).stream()
                .map(trainingMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<TrainingDto> getTrainingsByDistance(double distance) {
        return trainingRepository.findByDistance(distance).stream()
                .map(trainingMapper::toDto)
                .collect(Collectors.toList());
    }

    public TrainingDto updateTraining(Long id, TrainingDto trainingDto) {
        Training training = trainingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Training not found"));
        training.setActivityType(trainingDto.getActivityType());
        training.setStartTime(trainingDto.getStartTime());
        training.setEndTime(trainingDto.getEndTime());
        training.setDistance(trainingDto.getDistance());
        training.setCalories(trainingDto.getCalories());
        training.setUser(userProvider.getUser(trainingDto.getUserId()).get());
        training = trainingRepository.save(training);
        return trainingMapper.toDto(training);
    }
}
