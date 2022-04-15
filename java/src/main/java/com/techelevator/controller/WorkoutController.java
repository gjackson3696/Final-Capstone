package com.techelevator.controller;

import com.techelevator.dao.LoggedWorkoutDao;
import com.techelevator.dao.WorkoutDao;
import com.techelevator.model.LoggedWorkout;
import com.techelevator.model.Workout;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class WorkoutController {

    private WorkoutDao workoutDao;
    private LoggedWorkoutDao loggedWorkoutDao;

    public WorkoutController(WorkoutDao workoutDao, LoggedWorkoutDao loggedWorkoutDao) {
        this.workoutDao = workoutDao;
        this.loggedWorkoutDao = loggedWorkoutDao;
    }

    @RequestMapping(value = "/workouts/{memberId}", method = RequestMethod.GET)
    public List<Workout> getWorkoutsByMemberId(@PathVariable Long memberId) {
        return workoutDao.getWorkoutsByMemberId(memberId);
    }

    @RequestMapping(value = "/workouts/logged/{memberId}", method = RequestMethod.GET)
    public List<LoggedWorkout> getLoggedWorkoutsByMemberId(@PathVariable Long memberId) {
        return loggedWorkoutDao.getLoggedWorkoutsByMemberId(memberId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/workouts", method = RequestMethod.POST)
    public Workout addNewWorkout(@Valid @RequestBody Workout workout) {
        workoutDao.addNewWorkout(workout);
        return workout;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/workouts/log", method = RequestMethod.POST)
    public LoggedWorkout logWorkout(@Valid @RequestBody LoggedWorkout workout) {
        loggedWorkoutDao.logWorkout(workout);
        return workout;
    }

}
