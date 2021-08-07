package com.parkinglot;

import com.parkinglot.Process.StandardParking;

import java.util.List;

public class StandardParkingBoy {
    private final List<ParkingLot> parkingLots;
    private final StandardParking standardParking;

    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        standardParking = new StandardParking();
    }

    public ParkingTicket park (Car car) {
        return standardParking.park(car, parkingLots);
    }

}
