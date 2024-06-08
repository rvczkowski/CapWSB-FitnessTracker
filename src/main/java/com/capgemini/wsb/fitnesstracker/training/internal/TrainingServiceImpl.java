package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingServiceImpl {

    @Autowired
    private TrainingRepository trainingRepository;

    @Autowired
    private TrainingMapper trainingMapper;

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
        return trainingRepository.findByUserId(userId).stream()
                .map(trainingMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<TrainingDto> getCompletedTrainings(LocalDate date) {
        return trainingRepository.findByDateBefore(date).stream()
                .map(trainingMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<TrainingDto> getTrainingsByActivityType(String activityType) {
        return trainingRepository.findByActivityType(activityType).stream()
                .map(trainingMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<TrainingDto> getTrainingsByDistance(String activityType) {
        return trainingRepository.findByDistance(activityType).stream()
                .map(trainingMapper::toDto)
                .collect(Collectors.toList());
    }

    public TrainingDto updateTraining(Long id, TrainingDto trainingDto) {
        Training training = trainingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Training not found"));
        training.setActivityType(trainingDto.getActivityType());
        training.setDate(trainingDto.getDate());
        training.setDuration(trainingDto.getDuration());
        training.setDistance(trainingDto.setDistance());
        training.setCalories(trainingDto.getCalories());
        training.setUserId(trainingDto.getUserId());
        training = trainingRepository.save(training);
        return trainingMapper.toDto(training);
    }
}
