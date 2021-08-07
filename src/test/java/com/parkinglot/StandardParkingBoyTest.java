package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class StandardParkingBoyTest {

//    Given a parking lot, a standard parking boy, and a car
//    When park the car
//    Then return a parking ticket
    @Test
    void should_return_parking_ticket_when_park_given_a_parking_lot_a_standard_parking_boy_and_a_car() {
        // Given
        Car car = new Car();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(Collections.singletonList(new ParkingLot()));

        // When
        ParkingTicket parkingTicket = standardParkingBoy.park(car);

        // Then
        assertNotNull(parkingTicket);
    }

//    Given a parking lot with a parked car, a standard parking boy, and a parking ticket
//    When fetch the car
//    Then return the parked car
    @Test
    void should_return_car_when_fetch_given_a_parking_lot_and_a_standard_parking_boy_and_a_parking_ticket() {
        // Given
        Car car = new Car();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(Collections.singletonList(new ParkingLot()));
        ParkingTicket parkingTicket = standardParkingBoy.park(car);

        // When
        Car actualCar = standardParkingBoy.fetch(parkingTicket);

        // Then
        assertSame(car, actualCar);
    }
}
