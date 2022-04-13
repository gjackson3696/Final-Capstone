package com.techelevator.controller;

import com.techelevator.dao.WorkoutDao;
import com.techelevator.model.Workout;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class WorkoutController {

    private WorkoutDao workoutDao;

    public WorkoutController(WorkoutDao workoutDao) {
        this.workoutDao = workoutDao;
    }

    @RequestMapping(value = "/workouts/{memberId}", method = RequestMethod.GET)
    public List<Workout> getWorkoutsByMemberId(@PathVariable Long memberId) {
        return workoutDao.getWorkoutsByMemberId(memberId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/workouts", method = RequestMethod.POST)
    public void addNewWorkout(@Valid @RequestBody Workout workout) {
        workoutDao.addNewWorkout(workout);
    }

}
