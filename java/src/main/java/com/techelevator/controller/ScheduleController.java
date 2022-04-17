package com.techelevator.controller;

import com.techelevator.dao.ClassDao;
import com.techelevator.dao.ClassMembersDao;
import com.techelevator.dao.MemberDao;
import com.techelevator.exceptions.MemberNotFoundException;
import com.techelevator.model.Class;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/classes")
@PreAuthorize("permitAll")
public class ScheduleController {

    private ClassDao classDao;
    private ClassMembersDao classMembersDao;
    private MemberDao memberDao;

    public ScheduleController(ClassDao classDao, ClassMembersDao classMembersDao, MemberDao memberDao) {
        this.classDao = classDao;
        this.classMembersDao = classMembersDao;
        this.memberDao = memberDao;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Class> listAll() {
        return classDao.findAll();
    }

    @RequestMapping(value = "/week", method = RequestMethod.GET)
    public List<Class> listWeek(@RequestBody Date startDate) {
        return classDao.findWeekClasses(startDate);
    }

    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/register/{classId}", method = RequestMethod.POST)
    public void register(Principal principal, @PathVariable Long classId) {
        String username = principal.getName();
        try {
            Long memberId = memberDao.findMemberIdByUsername(username);
            classDao.registerMember(memberId,classId);
        } catch (Exception e) {
        }
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/unregister/{classId}", method = RequestMethod.DELETE)
    public void unregister(Principal principal, @PathVariable Long classId) {
        String username = principal.getName();
        try {
            Long memberId = memberDao.findMemberIdByUsername(username);
            classDao.unregisterMember(memberId,classId);
        } catch (Exception e) {
        }
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/registered", method = RequestMethod.GET)
    public List<Long> getRegisteredClasses(Principal principal) {
        String username = principal.getName();
        try {
            Long memberId = memberDao.findMemberIdByUsername(username);
            return classMembersDao.getRegisteredClassesByMemberId(memberId);
        } catch (Exception e) {
            return null;
        }
    }

}
