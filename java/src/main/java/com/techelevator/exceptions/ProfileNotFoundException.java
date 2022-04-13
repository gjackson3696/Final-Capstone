package com.techelevator.exceptions;

public class ProfileNotFoundException extends Exception {
    public ProfileNotFoundException(Long profileId) {
        super("Profile id "+profileId+" was not found.");
    }
}
