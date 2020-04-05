package com.demo.reservationapp.exception;

public class UserNotFoundException extends Exception {

    private Long userId;

    public UserNotFoundException(long userId) {
        super(String.format("User is not found with id: '%s'", userId));
    }
}
