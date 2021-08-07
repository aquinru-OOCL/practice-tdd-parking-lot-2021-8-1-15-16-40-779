package com.parkinglot;

import com.parkinglot.Process.SmartParking;

import java.util.List;

public class SmartParkingBoy extends StandardParkingBoy {
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        parkingStyle = new SmartParking();
    }

    @Override
    public ParkingTicket park(Car car) {
        return parkingStyle.park(car, parkingLots);
    }
}
