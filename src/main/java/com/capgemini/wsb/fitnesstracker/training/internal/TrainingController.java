package com.capgemini.wsb.fitnesstracker.training.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/trainings")
public class TrainingController {

    @Autowired
    private TrainingServiceImpl trainingService;

    @PostMapping
    public ResponseEntity<TrainingDto> createTraining(@RequestBody TrainingDto trainingDto) {
        TrainingDto createdTraining = trainingService.createTraining(trainingDto);
        return ResponseEntity.ok(createdTraining);
    }

    @GetMapping
    public ResponseEntity<List<TrainingDto>> getAllTrainings() {
        List<TrainingDto> trainings = trainingService.getAllTrainings();
        return ResponseEntity.ok(trainings);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TrainingDto>> getTrainingsByUserId(@PathVariable Long userId) {
        List<TrainingDto> trainings = trainingService.getTrainingsByUserId(userId);
        return ResponseEntity.ok(trainings);
    }

    @GetMapping("/completed/{date}")
    public ResponseEntity<List<TrainingDto>> getCompletedTrainings(@PathVariable Date date) {
        List<TrainingDto> trainings = trainingService.getCompletedTrainings(date);
        return ResponseEntity.ok(trainings);
    }

    @GetMapping("/activity/{activityType}")
    public ResponseEntity<List<TrainingDto>> getTrainingsByActivityType(@PathVariable ActivityType activityType) {
        List<TrainingDto> trainings = trainingService.getTrainingsByActivityType(activityType);
        return ResponseEntity.ok(trainings);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrainingDto> updateTraining(@PathVariable Long id, @RequestBody TrainingDto trainingDto) {
        TrainingDto updatedTraining = trainingService.updateTraining(id, trainingDto);
        return ResponseEntity.ok(updatedTraining);
    }

    @GetMapping("/{distance}")
    public ResponseEntity<List<TrainingDto>> getTrainingByDistance(@PathVariable Double distance) {
        List<TrainingDto> distanceTrainings = trainingService.getTrainingsByDistance(distance);
        return ResponseEntity.ok(distanceTrainings);
    }
}
