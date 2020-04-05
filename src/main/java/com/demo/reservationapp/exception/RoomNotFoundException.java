package com.demo.reservationapp.exception;

public class RoomNotFoundException extends Exception {

    private Long roomId;

    public RoomNotFoundException(long roomId) {
        super(String.format("User is not found with id: '%s'", roomId));
    }
}
