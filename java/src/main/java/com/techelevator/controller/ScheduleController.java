package com.techelevator.controller;

import com.techelevator.dao.ClassDao;
import com.techelevator.model.Class;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(Long memberId, Long classId) {
        classDao.registerMember(memberId,classId);
    }

    @RequestMapping(value = "/register", method = RequestMethod.DELETE)
    public void unregister(Long memberId, Long classId) {
        classDao.unregisterMember(memberId,classId);
    }

}
