package com.techelevator.model;

import javax.validation.constraints.NotNull;

public class LoggedWorkout extends Workout {
    @NotNull
    private String time, date;

    public LoggedWorkout() {
        super();
    }

    @Override
    public String getTime() {
        return time;
    }

    @Override
    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
