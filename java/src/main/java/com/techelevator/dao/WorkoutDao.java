package com.techelevator.dao;

import com.techelevator.model.Workout;

import java.util.List;

public interface WorkoutDao {

    List<Workout> getWorkoutsByUserId(Long userId);

    void addNewWorkout(Workout workout);

}
