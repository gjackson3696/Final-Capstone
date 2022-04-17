package com.techelevator.controller;

import com.techelevator.dao.ProfileDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exceptions.ProfileNotFoundException;
import com.techelevator.model.MemberProfile;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@CrossOrigin
@RequestMapping("/profile")
@PreAuthorize("isAuthenticated()")
public class ProfileController {

    private ProfileDao profileDao;
    private UserDao userDao;

    public ProfileController(ProfileDao profileDao, UserDao userDao) {
        this.profileDao = profileDao;
        this.userDao = userDao;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public MemberProfile getProfile(Principal principal) {
        try {
            String username = principal.getName();
            long memberId = userDao.findIdByUsername(username);
            return profileDao.getProfileByUserId(memberId);
        } catch(Exception e) {
            return null;
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public MemberProfile createProfile(Principal principal, @Valid @RequestBody MemberProfile profile) {
        populateUserId(principal,profile);
        return profileDao.createProfile(profile);
    }

    @RequestMapping(value = "/profile", method = RequestMethod.PUT)
    public boolean updateProfile(Principal principal, @Valid @RequestBody MemberProfile profile) {
        populateUserId(principal,profile);
        try {
            profileDao.updateProfile(profile);
        } catch(ProfileNotFoundException e) {
            return false;
        }
        return true;
    }

    private MemberProfile populateUserId(Principal principal, MemberProfile profile) {
        String username = principal.getName();
        long userId = userDao.findIdByUsername(username);
        profile.setUserId(userId);
        return profile;
    }
}
