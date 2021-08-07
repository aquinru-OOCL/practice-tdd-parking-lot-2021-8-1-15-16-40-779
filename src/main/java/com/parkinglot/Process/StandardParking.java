package com.parkinglot.Process;

import com.parkinglot.Car;
import com.parkinglot.Exceptions.NoAvailablePositionException;
import com.parkinglot.ParkingLot;
import com.parkinglot.ParkingTicket;

import java.util.List;

public class StandardParking {
    public ParkingTicket park(Car car, List<ParkingLot> parkingLots) {
        return parkingLots.stream()
                .findFirst()
                .orElseThrow(NoAvailablePositionException::new)
                .park(car);
    }
}
