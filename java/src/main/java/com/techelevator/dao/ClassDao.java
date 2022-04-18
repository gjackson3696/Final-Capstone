package com.techelevator.dao;

import com.techelevator.exceptions.ClassNotFoundException;
import com.techelevator.model.Class;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface ClassDao {

    List<Class> findAll();

    List<Class> findWeekClasses(Date startDate);

    Class getClassById(Long id) throws ClassNotFoundException;

    Class addClass(String name, String instructor, Time time, Date date, int lengthMinutes);

    void updateClass(Long classId, Class updatedClass) throws ClassNotFoundException;

    Class removeClass(Long id) throws ClassNotFoundException;

    List<Class> getRegisteredClasses(Long memberId);
}
