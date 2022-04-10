package com.techelevator.model;

import org.springframework.data.annotation.QueryAnnotation;

import javax.validation.constraints.NotNull;
import java.util.List;

public class Class {
    @NotNull
    private Long id;
    @NotNull
    private String name, instructor, time, date;
    @NotNull
    private int lengthMinutes;
    private List<Long> registeredMemberIds;

    public Class() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getLengthMinutes() {
        return lengthMinutes;
    }

    public void setLengthMinutes(int lengthMinutes) {
        this.lengthMinutes = lengthMinutes;
    }

    public void registerMember(Long memberId) {
        this.registeredMemberIds.add(memberId);
    }

    public boolean unregisterMember(Long memberId) {
        return this.registeredMemberIds.remove(memberId);
    }

    public List<Long> getRegisteredMemberIds() {
        return registeredMemberIds;
    }
}
