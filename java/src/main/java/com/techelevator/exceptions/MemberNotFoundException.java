package com.techelevator.exceptions;

public class MemberNotFoundException extends Exception {
    public MemberNotFoundException(Long memberId) {
        super("memberId "+memberId+" was now found.");
    }
}
