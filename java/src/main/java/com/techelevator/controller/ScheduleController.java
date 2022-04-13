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
    @RequestMapping(value = "/classSignUp", method = RequestMethod.POST)
    public void register(@PathVariable Long memberId, @PathVariable Long classId) {
        classDao.registerMember(memberId,classId);
    }

    @RequestMapping(value = "/classSignUp", method = RequestMethod.DELETE)
    public void unregister(@PathVariable Long memberId, @PathVariable Long classId) {
        classDao.unregisterMember(memberId,classId);
    }

}
