package com.parkinglot.Exceptions;

public class UnrecognizedTicketException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Unrecognized parking ticket.";
    }
}
