package com.techelevator.controller;

import com.techelevator.dao.LoggedWorkoutDao;
import com.techelevator.dao.UserDao;
import com.techelevator.dao.WorkoutDao;
import com.techelevator.model.LoggedWorkout;
import com.techelevator.model.Workout;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/workouts")
@PreAuthorize("isAuthenticated()")
public class WorkoutController {

    private WorkoutDao workoutDao;
    private LoggedWorkoutDao loggedWorkoutDao;
    private UserDao userDao;

    public WorkoutController(WorkoutDao workoutDao, LoggedWorkoutDao loggedWorkoutDao, UserDao userDao) {
        this.workoutDao = workoutDao;
        this.loggedWorkoutDao = loggedWorkoutDao;
        this.userDao = userDao;
    }

    @RequestMapping(value = "/{memberId}", method = RequestMethod.GET)
    public List<Workout> getWorkoutsByMemberId(Principal principal) {
        String username = principal.getName();
        try {
            long memberId = userDao.findIdByUsername(username);
            return workoutDao.getWorkoutsByUserId(memberId);
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "/logged/{memberId}", method = RequestMethod.GET)
    public List<LoggedWorkout> getLoggedWorkoutsByMemberId(Principal principal) {
        String username = principal.getName();
        try {
            long memberId = userDao.findIdByUsername(username);
            return loggedWorkoutDao.getLoggedWorkoutsByUserId(memberId);
        } catch (Exception e) {
            return null;
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Workout addNewWorkout(Principal principal, @Valid @RequestBody Workout workout) {
        populateUserId(principal,workout);
        workoutDao.addNewWorkout(workout);
        return workout;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/log", method = RequestMethod.POST)
    public LoggedWorkout logWorkout(Principal principal, @Valid @RequestBody LoggedWorkout workout) {
        populateUserId(principal,workout);
        loggedWorkoutDao.logWorkout(workout);
        return workout;
    }

    private Workout populateUserId(Principal principal, Workout workout) {
        String username = principal.getName();
        long userId = userDao.findIdByUsername(username);
        workout.setUserId(userId);
        return workout;
    }
}
