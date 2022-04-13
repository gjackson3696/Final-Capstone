package com.techelevator.exceptions;

public class GoalsNotFoundException extends Exception {
    public GoalsNotFoundException(Long goalsId) {
        super("Goals id "+goalsId+" was not found.");
    }
}
