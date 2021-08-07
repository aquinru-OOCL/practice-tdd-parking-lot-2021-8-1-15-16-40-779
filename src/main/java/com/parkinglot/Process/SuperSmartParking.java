package com.parkinglot.Process;

import com.parkinglot.Car;
import com.parkinglot.Exceptions.NoAvailablePositionException;
import com.parkinglot.ParkingLot;
import com.parkinglot.ParkingTicket;

import java.util.Comparator;
import java.util.List;

public class SuperSmartParking implements ParkingStyle{
    @Override
    public ParkingTicket park(Car car, List<ParkingLot> parkingLots) {
        return parkingLots.stream()
                .max(Comparator.comparingDouble(ParkingLot::getPositionRate))
                .orElseThrow(NoAvailablePositionException::new)
                .park(car);
    }
}
