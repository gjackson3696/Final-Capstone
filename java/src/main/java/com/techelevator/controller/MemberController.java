package com.techelevator.controller;

import com.techelevator.dao.MemberDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exceptions.MemberNotFoundException;
import com.techelevator.model.Member;
import com.techelevator.model.MemberProfile;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@CrossOrigin
@RequestMapping("/member")
@PreAuthorize("permitAll")
//@PreAuthorize("isAuthenticated()")
public class MemberController {

    private MemberDao memberDao;
    private UserDao userDao;

    public MemberController(MemberDao memberDao, UserDao userDao) {
        this.memberDao = memberDao;
        this.userDao = userDao;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Member getMember(Principal principal) {
        try {
            String username = principal.getName();
            long userId = userDao.findIdByUsername(username);
            return memberDao.getMemberByUserId(userId);
        } catch(MemberNotFoundException e) {
            return null;
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Member createMember(@Valid @RequestBody Member member) {
        return memberDao.create(member);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public boolean updateMember(@Valid @RequestBody Member member) {
        try {
            memberDao.updateMember(member);
        } catch (MemberNotFoundException e) {
            return false;
        }
        return true;
    }
}
