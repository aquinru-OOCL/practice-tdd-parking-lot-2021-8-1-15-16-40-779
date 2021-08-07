package com.parkinglot;

import com.parkinglot.Process.Fetching;
import com.parkinglot.Process.ParkingStyle;
import com.parkinglot.Process.StandardParking;

import java.util.List;

public class StandardParkingBoy {
    protected List<ParkingLot> parkingLots;
    protected ParkingStyle parkingStyle;
    private final Fetching fetching;

    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        parkingStyle = new StandardParking();
        fetching = new Fetching();
    }

    public ParkingTicket park (Car car) {
        return parkingStyle.park(car, parkingLots);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return fetching.fetch(parkingTicket, parkingLots);
    }

    public List<ParkingLot> getParkingLotList() {
        return parkingLots;
    }

}
