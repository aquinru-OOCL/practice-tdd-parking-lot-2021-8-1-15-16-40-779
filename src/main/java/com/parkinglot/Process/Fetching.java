package com.parkinglot.Process;

import com.parkinglot.Car;
import com.parkinglot.Exceptions.UnrecognizedTicketException;
import com.parkinglot.ParkingLot;
import com.parkinglot.ParkingTicket;

import java.util.List;

public class Fetching {
    public Car fetch(ParkingTicket parkingTicket, List<ParkingLot> parkingLots) {
        return parkingLots.stream()
                .findFirst()
                .orElseThrow(UnrecognizedTicketException::new)
                .fetch(parkingTicket);
    }
}
