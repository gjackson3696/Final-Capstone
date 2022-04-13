package com.techelevator.controller;

import com.techelevator.dao.ClassDao;
import com.techelevator.dao.ClassMembersDao;
import com.techelevator.model.Class;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class ScheduleController {

    private ClassDao classDao;
    private ClassMembersDao classMembersDao;

    public ScheduleController(ClassDao classDao, ClassMembersDao classMembersDao) {
        this.classDao = classDao;
        this.classMembersDao = classMembersDao;
    }

    @RequestMapping(value = "/classes", method = RequestMethod.GET)
    public List<Class> listAll() {
        return classDao.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/classes/signUp", method = RequestMethod.POST)
    public void register(@PathVariable Long memberId, @PathVariable Long classId) {
        classDao.registerMember(memberId,classId);
    }

    @RequestMapping(value = "/classes/signUp", method = RequestMethod.DELETE)
    public void unregister(@PathVariable Long memberId, @PathVariable Long classId) {
        classDao.unregisterMember(memberId,classId);
    }

    @RequestMapping(value = "/classes/registered", method = RequestMethod.GET)
    public List<Long> getRegisteredClassesByMemberId(@PathVariable Long memberId) {
        return classMembersDao.getRegisteredClassesByMemberId(memberId);
    }

}
