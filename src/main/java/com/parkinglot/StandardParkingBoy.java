package com.parkinglot;

import com.parkinglot.Process.Fetching;
import com.parkinglot.Process.StandardParking;

import java.util.List;

public class StandardParkingBoy {
    private final List<ParkingLot> parkingLots;
    private final StandardParking standardParking;
    private final Fetching fetching;

    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        standardParking = new StandardParking();
        fetching = new Fetching();
    }

    public ParkingTicket park (Car car) {
        return standardParking.park(car, parkingLots);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return fetching.fetch(parkingTicket, parkingLots);
    }

    public List<ParkingLot> getParkingLotList() {
        return parkingLots;
    }

}
