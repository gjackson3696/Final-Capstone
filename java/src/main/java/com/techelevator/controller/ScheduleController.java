package com.techelevator.controller;

import com.techelevator.dao.ClassDao;
import com.techelevator.model.Class;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ScheduleController {

    private ClassDao classDao;

    public ScheduleController(ClassDao classDao) {
        this.classDao = classDao;
    }

    @RequestMapping(value = "/classes", method = RequestMethod.GET)
    public List<Class> listAll() {
        return classDao.findAll();
    }
}
