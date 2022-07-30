package com.aiotouch.emojiquizapp.exception;

import org.springframework.core.NestedRuntimeException;

public class QuestionNotFoundException extends NestedRuntimeException {

    public QuestionNotFoundException(String message) {
        super(message);
    }
}
