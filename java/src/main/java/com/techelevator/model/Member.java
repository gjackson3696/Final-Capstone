package com.techelevator.model;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

public class Member {
    private Long memberId, profileId, goalsId;
    private Long userId;
    @NotNull
    private String firstName, lastName, email;

    public Member() { }

    public Member(Long memberId, Long profileId, Long goalsId, Long userId, String firstName, String lastName, String email) {
        this.memberId = memberId;
        this.profileId = profileId;
        this.goalsId = goalsId;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public Long getGoalsId() {
        return goalsId;
    }

    public void setGoalsId(Long goalsId) {
        this.goalsId = goalsId;
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

}
