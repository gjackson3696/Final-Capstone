package com.techelevator.dao;

import com.techelevator.exceptions.GoalsNotFoundException;
import com.techelevator.exceptions.ProfileNotFoundException;
import com.techelevator.model.MemberGoals;
import com.techelevator.model.MemberProfile;

public interface GoalsDao {

    MemberGoals getGoalsByUserId(Long userId) throws GoalsNotFoundException;

    MemberGoals getGoalsByGoalsId(Long goalsId) throws GoalsNotFoundException;

    MemberGoals createGoals(MemberGoals goals);

    void updateGoals(MemberGoals goals) throws GoalsNotFoundException;
    
}
