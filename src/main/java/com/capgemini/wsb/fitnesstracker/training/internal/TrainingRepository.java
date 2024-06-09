package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TrainingRepository extends JpaRepository<Training, Long> {
    List<Training> findByUser(User user);
    List<Training> findByStartTimeBefore(Date date);
    List<Training> findByActivityType(ActivityType activityType);
    List<Training> findByDistance(double distance);
}
