package com.parkinglot;

import com.parkinglot.Process.SuperSmartParking;

import java.util.List;

public class SuperSmartParkingBoy extends StandardParkingBoy {
    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        parkingStyle = new SuperSmartParking();
    }

    @Override
    public ParkingTicket park(Car car) {
        return parkingStyle.park(car, parkingLots);
    }
}
