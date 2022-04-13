package com.techelevator.controller;

import com.techelevator.dao.MemberDao;
import com.techelevator.exceptions.MemberNotFoundException;
import com.techelevator.model.Member;
import com.techelevator.model.MemberProfile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class MemberController {

    private MemberDao memberDao;

    public MemberController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public Member getMember(@PathVariable Long memberId) {
        try {
            return memberDao.getMemberByMemberId(memberId);
        } catch(MemberNotFoundException e) {
            return null;
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/member", method = RequestMethod.POST)
    public Member createMember(@Valid @RequestBody Member member) {
        return memberDao.create(member);
    }

    @RequestMapping(value = "/member", method = RequestMethod.PUT)
    public boolean updateMember(@Valid @RequestBody Member member) {
        try {
            memberDao.updateMember(member);
        } catch (MemberNotFoundException e) {
            return false;
        }
        return true;
    }
}
