package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Map<ParkingTicket, Car> parkedPositions = new HashMap<>();

    public ParkingTicket park(Car car) {
        if (isParkingLotFull()){
            //Implement exception handling
            return null;
        }
        ParkingTicket parkingTicket = new ParkingTicket();
        parkedPositions.put(parkingTicket, car);
        return parkingTicket;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        Car car = parkedPositions.get(parkingTicket);
        parkedPositions.remove(parkingTicket);
        return car;
    }

    public Boolean isParkingLotFull() {
        return parkedPositions.size() >= 10;
    }
}
