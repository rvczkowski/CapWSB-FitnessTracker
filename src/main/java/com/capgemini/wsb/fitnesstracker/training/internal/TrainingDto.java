package com.capgemini.wsb.fitnesstracker.training.internal;

import java.time.LocalDate;

public class TrainingDto {
    private Long id;
    private String activityType;
    private LocalDate date;
    private String duration;
    private double distance;
    private Long userId;

    // Konstruktor bezargumentowy
    public TrainingDto() {}

    // Konstruktor z argumentami
    public TrainingDto(Long id, String activityType, LocalDate date, String duration, double distance, Long userId) {
        this.id = id;
        this.activityType = activityType;
        this.date = date;
        this.duration = duration;
        this.distance = distance;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
