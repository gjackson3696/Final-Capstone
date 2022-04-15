package com.techelevator.dao;

import com.techelevator.model.LoggedWorkout;
import com.techelevator.model.Workout;

import java.util.List;

public interface LoggedWorkoutDao {

    List<LoggedWorkout> getLoggedWorkoutsByMemberId(Long memberId);

    void logWorkout(LoggedWorkout workout);
}
