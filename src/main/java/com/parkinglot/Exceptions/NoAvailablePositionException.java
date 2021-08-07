package com.parkinglot.Exceptions;

public class NoAvailablePositionException extends RuntimeException {
    @Override
    public String getMessage() {
        return "No available position.";
    }
}
