package com.techelevator.model;

import javax.validation.constraints.NotNull;

public class LoggedWorkout {
    private Long loggedWorkoutId;
    @NotNull
    private Long memberId;
    @NotNull
    private String name, domain, structure;
    private String weights = "", time = "", rounds = "";
    private boolean completed = false;

    public LoggedWorkout() { }

    public Long getLoggedWorkoutId() {
        return loggedWorkoutId;
    }

    public void setLoggedWorkoutId(Long loggedWorkoutId) {
        this.loggedWorkoutId = loggedWorkoutId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getWeights() {
        return weights;
    }

    public void setWeights(String weights) {
        this.weights = weights;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRounds() {
        return rounds;
    }

    public void setRounds(String rounds) {
        this.rounds = rounds;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
