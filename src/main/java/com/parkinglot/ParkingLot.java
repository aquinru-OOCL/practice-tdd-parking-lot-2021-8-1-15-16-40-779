package com.parkinglot;

import com.parkinglot.Exceptions.NoAvailablePositionException;
import com.parkinglot.Exceptions.UnrecognizedTicketException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Map<ParkingTicket, Car> parkedPositions = new HashMap<>();
    private final int capacity;
    private static final int DEFAULT_CAPACITY = 10;

    public ParkingLot() {
        this.capacity = DEFAULT_CAPACITY;
    }

    public ParkingLot(int parkingLotSize) {
        this.capacity = parkingLotSize;
    }

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
        return getCountParkedCars() >= capacity;
    }

    public Boolean hasInvalidTicket(ParkingTicket parkingTicket) {
        return !parkedPositions.containsKey(parkingTicket);
    }

    public int getCountParkedCars() {
        return parkedPositions.size();
    }

    public int getAvailableCapacity() {
        return capacity - getCountParkedCars();
    }

    public double getPositionRate() {
        return (double) getAvailableCapacity() / capacity;
    }
}
