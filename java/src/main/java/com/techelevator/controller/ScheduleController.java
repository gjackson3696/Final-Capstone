package com.techelevator.controller;

import com.techelevator.dao.ClassDao;
import com.techelevator.dao.ClassMembersDao;
import com.techelevator.model.Class;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/classes")
@PreAuthorize("permitAll")
public class ScheduleController {

    private ClassDao classDao;
    private ClassMembersDao classMembersDao;

    public ScheduleController(ClassDao classDao, ClassMembersDao classMembersDao) {
        this.classDao = classDao;
        this.classMembersDao = classMembersDao;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Class> listAll() {
        return classDao.findAll();
    }

    @RequestMapping(value = "/week", method = RequestMethod.GET)
    public List<Class> listWeek(@RequestBody Date startDate) {
        return classDao.findWeekClasses(startDate);
    }

    //@PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody IDs ids) {
        classDao.registerMember(ids.memberId,ids.classId);

    }

    //@PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/unregister", method = RequestMethod.DELETE)
    public void unregister(@RequestBody IDs ids) {
        classDao.unregisterMember(ids.memberId,ids.classId);
    }

    //@PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/registered/{memberId}", method = RequestMethod.GET)
    public List<Long> getRegisteredClassesByMemberId(@PathVariable Long memberId) {
        return classMembersDao.getRegisteredClassesByMemberId(memberId);
    }

    static class IDs {
        Long memberId, classId;

        IDs(Long memberId, Long classId) {
            this.memberId = memberId;
            this.classId = classId;
        }
    }

}
