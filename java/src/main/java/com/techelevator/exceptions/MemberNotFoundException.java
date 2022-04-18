package com.techelevator.exceptions;

public class MemberNotFoundException extends Exception {
    public MemberNotFoundException(Long memberId) {
        super("memberId "+memberId+" was now found.");
    }

    public MemberNotFoundException(String username) {
        super("username: "+username+" is not a member.");
    }
}
