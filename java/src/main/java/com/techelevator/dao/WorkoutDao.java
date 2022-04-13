package com.techelevator.dao;

import com.techelevator.model.Workout;

import java.util.List;

public interface WorkoutDao {

    List<Workout> getWorkoutsByMemberId(Long memberId);

    void addNewWorkout(Workout workout);

}
