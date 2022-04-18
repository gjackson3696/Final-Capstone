package com.techelevator.controller;

import com.techelevator.dao.GoalsDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exceptions.GoalsNotFoundException;
import com.techelevator.model.MemberGoals;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@CrossOrigin
@RequestMapping("/goals")
@PreAuthorize("isAuthenticated()")
public class GoalsController {

    private GoalsDao goalsDao;
    private UserDao userDao;

    public GoalsController(GoalsDao goalsDao, UserDao userDao) {
        this.goalsDao = goalsDao;
        this.userDao = userDao;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public MemberGoals getGoals(Principal principal) {
        String username = principal.getName();
        try {
            long userId = userDao.findIdByUsername(username);
            return goalsDao.getGoalsByUserId(userId);
        } catch(Exception e) {
            return null;
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "", method = RequestMethod.POST)
    public MemberGoals createGoals(Principal principal, @Valid @RequestBody MemberGoals goals) {
        populateUserId(principal,goals);
        return goalsDao.createGoals(goals);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public boolean updateGoals(Principal principal, @Valid @RequestBody MemberGoals goals) {
        populateUserId(principal,goals);
        try {
            goalsDao.updateGoals(goals);
        } catch(GoalsNotFoundException e) {
            return false;
        }
        return true;
    }

    private MemberGoals populateUserId(Principal principal, MemberGoals goals) {
        String username = principal.getName();
        long userId = userDao.findIdByUsername(username);
        goals.setUserId(userId);
        return goals;
    }
}
