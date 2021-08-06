package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class ParkingLotTest {

//    Given a parking lot and a car
//    When parking a car
//    Then return a parking ticket
    @Test
    public void should_return_parking_ticket_when_park_given_a_parking_lot_and_a_car() {
        // Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        // When
        ParkingTicket parkingTicket = parkingLot.park(car);

        // Then
        assertNotNull(parkingTicket);
    }

//    Given a parking lot with a parked car, and corresponding parking ticket
//    When fetching a car
//    Then return the car
    @Test
    public void should_return_car_when_fetch_given_a_parking_lot_with_a_parked_car_and_corresponding_ticket() {
    // Given
    ParkingLot parkingLot = new ParkingLot();
    Car car = new Car();
    ParkingTicket parkingTicket = parkingLot.park(car);

    // When
    Car actualCar = parkingLot.fetch(parkingTicket);

    // Then
    assertEquals(car, actualCar);
    }
}
