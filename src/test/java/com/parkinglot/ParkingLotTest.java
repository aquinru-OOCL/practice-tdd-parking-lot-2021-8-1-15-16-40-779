package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


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

//    Given a parking lot with two parked cars, and two parking tickets
//    When fetching two cars
//    Then return the right car with corresponding ticket
    @Test
    public void should_return_the_right_car_when_fetch_two_cars_given_a_parking_lot_with_two_parked_cars_and_two_parking_tickets() {
        // Given
        ParkingLot parkingLot = new ParkingLot();
        Car aliceCar = new Car();
        Car bobCar = new Car();
        ParkingTicket aliceParkingTicket = parkingLot.park(aliceCar);
        ParkingTicket bobParkingTicket = parkingLot.park(bobCar);

        // When
        Car actualAliceCar = parkingLot.fetch(aliceParkingTicket);
        Car actualBobCar = parkingLot.fetch(bobParkingTicket);

        // Then
        assertEquals(aliceCar, actualAliceCar);
        assertEquals(bobCar, actualBobCar);
    }

//    Given in a parking lot and a wrong parking ticket
//    When fetching a car
//    Then return nothing
    @Test
    public void should_return_no_car_when_fetch_given_a_parking_lot_and_wrong_parking_ticket() {
        // Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.park(car);
        ParkingTicket wrongParkingTicket = new ParkingTicket();

        // When
        Car actualCar = parkingLot.fetch(wrongParkingTicket);

        // Then
        assertNull(actualCar);
    }

}
