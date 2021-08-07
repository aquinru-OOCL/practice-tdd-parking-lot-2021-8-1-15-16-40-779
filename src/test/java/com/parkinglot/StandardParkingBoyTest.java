package com.parkinglot;

import com.parkinglot.Exceptions.NoAvailablePositionException;
import com.parkinglot.Exceptions.UnrecognizedTicketException;
import static java.util.Arrays.asList;
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

//    Given a parking lot, a standard parking boy, and a used parking ticket
//    When fetch the car
//    Then return nothing with error message "Unrecognized parking ticket."
    @Test
    void should_return_no_car_with_error_message_when_fetch_given_a_parking_lot_and_a_standard_parking_boy_and_a_used_parking_ticket() {
        // Given
        Car car = new Car();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(Collections.singletonList(new ParkingLot()));
        ParkingTicket parkingTicket = standardParkingBoy.park(car);
        standardParkingBoy.fetch(parkingTicket);

        // When
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> standardParkingBoy.fetch(parkingTicket));

        // Then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

//    Given a parking lot without any position, a standard parking boy, and a car
//    When park the car
//    Then return nothing with error message "No available position."
    @Test
    void should_return_no_parking_ticket_with_error_message_when_park_given_a_parking_lot_without_any_position_and_a_standard_parking_boy_and_a_car() {
        // Given
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(Collections.singletonList(new ParkingLot()));
        for (int i = 0; i < 10; i++) {
            standardParkingBoy.park(new Car());
        }

        Car eleventhCar = new Car();

        // When
        Exception exception = assertThrows(NoAvailablePositionException.class, () -> standardParkingBoy.park(eleventhCar));

        // Then
        assertEquals("No available position.", exception.getMessage());

    }

//    Given a standard parking boy, who manage two parking lots, both with available position, and a car
//    When park the car
//    Then the car will be parked to the first parking lot
    @Test
    void should_park_in_first_parking_lot_when_park_given_a_standard_parking_boy_who_manage_two_parking_lots_both_with_available_position() {
        // Given
        Car car = new Car();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(asList(new ParkingLot(), new ParkingLot()));

        // When
        standardParkingBoy.park(car);

        // Then
        assertEquals(1, standardParkingBoy.getParkingLotList().get(0).getCountParkedCars());
    }

//    Given a standard parking boy, who manage two parking lots, first is full and second with available position, and a car
//    When park the car
//    Then the car will be parked to the second parking lot
    @Test
    void should_park_in_second_parking_lot_when_park_given_a_standard_parking_boy_who_manage_two_parking_lots_first_is_full_and_second_with_available_position() {
        // Given
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(asList(new ParkingLot(), new ParkingLot()));
        for (int i = 0; i < 10; i++) {
            standardParkingBoy.park(new Car());
        }

        Car eleventhCar = new Car();

        // When
        standardParkingBoy.park(eleventhCar);

        // Then
        assertEquals(10, standardParkingBoy.getParkingLotList().get(0).getCountParkedCars()); //First parking lot should be 10
        assertEquals(1, standardParkingBoy.getParkingLotList().get(1).getCountParkedCars()); //Second parking lot should be 1

    }
}
