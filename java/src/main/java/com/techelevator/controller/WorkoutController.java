package com.techelevator.controller;

import com.techelevator.dao.LoggedWorkoutDao;
import com.techelevator.dao.WorkoutDao;
import com.techelevator.model.LoggedWorkout;
import com.techelevator.model.Workout;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/workouts")
@PreAuthorize("permitAll")
//@PreAuthorize("isAuthenticated()")
public class WorkoutController {

    private WorkoutDao workoutDao;
    private LoggedWorkoutDao loggedWorkoutDao;

    public WorkoutController(WorkoutDao workoutDao, LoggedWorkoutDao loggedWorkoutDao) {
        this.workoutDao = workoutDao;
        this.loggedWorkoutDao = loggedWorkoutDao;
    }

    @RequestMapping(value = "/{memberId}", method = RequestMethod.GET)
    public List<Workout> getWorkoutsByMemberId(@PathVariable Long memberId) {
        return workoutDao.getWorkoutsByMemberId(memberId);
    }

    @RequestMapping(value = "/logged/{memberId}", method = RequestMethod.GET)
    public List<LoggedWorkout> getLoggedWorkoutsByMemberId(@PathVariable Long memberId) {
        return loggedWorkoutDao.getLoggedWorkoutsByMemberId(memberId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Workout addNewWorkout(@Valid @RequestBody Workout workout) {
        workoutDao.addNewWorkout(workout);
        return workout;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/log", method = RequestMethod.POST)
    public LoggedWorkout logWorkout(@Valid @RequestBody LoggedWorkout workout) {
        loggedWorkoutDao.logWorkout(workout);
        return workout;
    }

}
