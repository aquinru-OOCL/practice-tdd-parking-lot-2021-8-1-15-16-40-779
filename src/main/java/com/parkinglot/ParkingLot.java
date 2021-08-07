package com.parkinglot;

import com.parkinglot.Exceptions.NoAvailablePositionException;
import com.parkinglot.Exceptions.UnrecognizedTicketException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Map<ParkingTicket, Car> parkedPositions = new HashMap<>();

    public ParkingTicket park(Car car) {
        if (isParkingLotFull()){
            throw new NoAvailablePositionException();
        }
        ParkingTicket parkingTicket = new ParkingTicket();
        parkedPositions.put(parkingTicket, car);
        return parkingTicket;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if (hasInvalidTicket(parkingTicket)) {
            throw new UnrecognizedTicketException();
        }

        Car car = parkedPositions.get(parkingTicket);
        parkedPositions.remove(parkingTicket);
        return car;
    }

    public Boolean isParkingLotFull() {
        return getCountParkedCars() >= 10;
    }

    public Boolean hasInvalidTicket(ParkingTicket parkingTicket) {
        return !parkedPositions.containsKey(parkingTicket);
    }

    public int getCountParkedCars() {
        return parkedPositions.size();
    }
}
