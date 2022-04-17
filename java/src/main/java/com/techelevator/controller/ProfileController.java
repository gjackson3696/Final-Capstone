package com.techelevator.controller;

import com.techelevator.dao.ProfileDao;
import com.techelevator.exceptions.ProfileNotFoundException;
import com.techelevator.model.MemberProfile;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/profile")
@PreAuthorize("permitAll")
//@PreAuthorize("isAuthenticated()")
public class ProfileController {

    private ProfileDao profileDao;

    public ProfileController(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public MemberProfile getProfile(@PathVariable Long memberId) {
        try {
            return profileDao.getProfileByMemberId(memberId);
        } catch(ProfileNotFoundException e) {
            return null;
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public MemberProfile createProfile(@Valid @RequestBody MemberProfile profile) {
        return profileDao.createProfile(profile);
    }

    @RequestMapping(value = "/profile", method = RequestMethod.PUT)
    public boolean updateProfile(@Valid @RequestBody MemberProfile profile) {
        try {
            profileDao.updateProfile(profile);
        } catch(ProfileNotFoundException e) {
            return false;
        }
        return true;
    }
}
