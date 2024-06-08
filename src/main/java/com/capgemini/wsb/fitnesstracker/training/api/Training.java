package com.capgemini.wsb.fitnesstracker.training.api;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String activityType;
    private Date startTime;
    private Date endTime;
    private double distance;
    private double calories;
    private Long userId;

    // Konstruktor bezargumentowy wymagany przez JPA
    public Training() {}

    // Konstruktor z argumentami
    public Training(String activityType, Date startTime, Date endTime, double distance, double calories, Long userId) {
        this.activityType = activityType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.distance = distance;
        this.calories = calories;
        this.userId = userId;
    }

    // Konstruktor z wszystkimi argumentami, w tym id
    public Training(Long id, String activityType, Date startTime, Date endTime, double distance, double calories, Long userId) {
        this.id = id;
        this.activityType = activityType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.distance = distance;
        this.calories = calories;
        this.userId = userId;
    }

    // Gettery i Settery
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
