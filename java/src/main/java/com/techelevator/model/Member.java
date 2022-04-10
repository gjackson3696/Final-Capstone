package com.techelevator.model;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

public class Member {
    private Long memberId;
    @NotNull
    private Long userId;
    @NotNull
    private String firstName, lastName, email;
    private Map<String,String> profile, goals;

    public Member(Long memberId, Long userId, String firstName, String lastName, String email) {
        this.memberId = memberId;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.profile = new HashMap<>();
        this.goals = new HashMap<>();
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, String> getProfile() {
        return profile;
    }

    public void setProfile(Map<String, String> profile) {
        this.profile = profile;
    }

    public void addProfileDetail(String key, String value) {
        this.profile.put(key,value);
    }

    public Map<String, String> getGoals() {
        return goals;
    }

    public void setGoals(Map<String, String> goals) {
        this.goals = goals;
    }

    public void addGoal(String key, String value) {
        this.goals.put(key,value);
    }
}
