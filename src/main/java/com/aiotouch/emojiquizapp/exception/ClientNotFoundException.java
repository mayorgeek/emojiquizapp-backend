package com.aiotouch.emojiquizapp.exception;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(String username) {
        super("Client does not exist: " + username);
    }
}
