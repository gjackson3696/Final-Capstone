package com.techelevator.controller;

import com.techelevator.dao.GoalsDao;
import com.techelevator.exceptions.GoalsNotFoundException;
import com.techelevator.exceptions.MemberNotFoundException;
import com.techelevator.model.MemberGoals;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/goals")
@PreAuthorize("permitAll")
//@PreAuthorize("isAuthenticated()")
public class GoalsController {

    private GoalsDao goalsDao;

    public GoalsController(GoalsDao goalsDao) {
        this.goalsDao = goalsDao;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public MemberGoals getGoals(@PathVariable Long memberId) {
        try {
            return goalsDao.getGoalsByMemberId(memberId);
        } catch(GoalsNotFoundException e) {
            return null;
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "", method = RequestMethod.POST)
    public MemberGoals createGoals(@Valid @RequestBody MemberGoals goals) {
        return goalsDao.createGoals(goals);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public boolean updateGoals(@Valid @RequestBody MemberGoals goals) {
        try {
            goalsDao.updateGoals(goals);
        } catch(GoalsNotFoundException e) {
            return false;
        }
        return true;
    }
}