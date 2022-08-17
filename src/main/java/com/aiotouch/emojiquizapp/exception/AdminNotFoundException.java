package com.aiotouch.emojiquizapp.exception;

public class AdminNotFoundException extends RuntimeException {

    public AdminNotFoundException(String username) {
        super("Admin Does Not Exist: " + username);
    }
}
