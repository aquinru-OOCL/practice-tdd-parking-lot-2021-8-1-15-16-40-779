package com.parkinglot.Process;

import com.parkinglot.Car;
import com.parkinglot.ParkingLot;
import com.parkinglot.ParkingTicket;

import java.util.List;

public interface ParkingStyle {
    ParkingTicket park(Car car, List<ParkingLot> parkingLots);
}
