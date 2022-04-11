package com.techelevator.dao;

import com.techelevator.model.Class;

import java.util.List;

public interface ClassDao {

    List<Class> findAll();

    Class getClassById(Long id);

    boolean addClass(String name, String instructor, String time, String date, int lengthMinutes);

    boolean updateClass(Class updatedClass);

    boolean removeClass(Long id);

}
