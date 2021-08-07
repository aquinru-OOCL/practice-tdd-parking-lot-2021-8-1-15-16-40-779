package com.parkinglot;

import com.parkinglot.Exceptions.UnrecognizedTicketException;
import com.parkinglot.Process.StandardParking;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

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

//    Given a parking lot with two parked cars, a standard parking boy, and two parking tickets
//    When fetch the car twice
//    Then return the right car with each ticket
    @Test
    void should_return_the_right_car_when_fetch_twice_given_a_parking_lot_with_two_parked_cars_and_a_standard_parking_boy_and_two_parking_tickets() {
        // Given
        Car firstCar = new Car();
        Car secondCar = new Car();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(Collections.singletonList(new ParkingLot()));
        ParkingTicket firstParkingTicket = standardParkingBoy.park(firstCar);
        ParkingTicket secondParkingTicket = standardParkingBoy.park(secondCar);

        // When
        Car firstFetchedCar = standardParkingBoy.fetch(firstParkingTicket);
        Car secondFetchedCar = standardParkingBoy.fetch(secondParkingTicket);

        // Then
        assertSame(firstCar, firstFetchedCar);
        assertSame(secondCar, secondFetchedCar);

    }

//    Given a parking lot, a standard parking boy, and a wrong parking ticket
//    When fetch the car
//    Then return nothing with error message "Unrecognized parking ticket."
    @Test
    void should_return_no_car_with_error_message_when_fetch_given_a_parking_lot_and_a_standard_parking_boy_and_a_wrong_parking_ticket() {
        // Given
        Car car = new Car();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(Collections.singletonList(new ParkingLot()));
        standardParkingBoy.park(car);
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();

        // When
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> standardParkingBoy.fetch(unrecognizedParkingTicket));

        // Then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }
}
