package com.techelevator.exceptions;

public class ClassNotFoundException extends Exception {
    public ClassNotFoundException(Long classId) {
        super("Class id "+classId+" was not found.");
    }
}
