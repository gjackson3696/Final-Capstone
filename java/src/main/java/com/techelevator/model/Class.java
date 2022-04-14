package com.techelevator.model;

import org.springframework.data.annotation.QueryAnnotation;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.List;

public class Class {
    private Long id;
    @NotEmpty
    private String name, instructor;
    @NotNull
    private Time time;
    @NotNull
    private Date date;
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

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getEndOfWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 7);
        return (Date) calendar.getTime();
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

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", instructor='" + instructor + '\'' +
                ", date='" + date + '\'' +
                ", startTime='" + time + '\'' +
                ", lengthInMinutes='" + lengthMinutes + '\'' +
                '}';
    }
}
