package com.mikola.java_learn_api.exception;

public class ChatGptException extends RuntimeException {
    public ChatGptException(String message) {
        super(message);
    }
}
