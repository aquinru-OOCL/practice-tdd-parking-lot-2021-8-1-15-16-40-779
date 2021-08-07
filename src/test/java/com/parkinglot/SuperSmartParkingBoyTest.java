package com.parkinglot;

import com.parkinglot.Exceptions.NoAvailablePositionException;
import com.parkinglot.Exceptions.UnrecognizedTicketException;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

public class SuperSmartParkingBoyTest {

//    Given a parking lot, a super smart parking boy, and a car
//    When park the car
//    Then return a parking ticket
    @Test
    void should_return_parking_ticket_when_park_given_a_parking_lot_a_smart_parking_boy_and_a_car() {
        // Given
        Car car = new Car();
        SuperSmartParkingBoy superSuperSmartParkingBoy = new SuperSmartParkingBoy(Collections.singletonList(new ParkingLot()));

        // When
        ParkingTicket parkingTicket = superSuperSmartParkingBoy.park(car);

        // Then
        assertNotNull(parkingTicket);
    }

//    Given a parking lot with a parked car, a super smart parking boy, and a parking ticket
//    When fetch the car
//    Then return the parked car
    @Test
    void should_return_car_when_fetch_given_a_parking_lot_and_a_smart_parking_boy_and_a_parking_ticket() {
        // Given
        Car car = new Car();
        SuperSmartParkingBoy superSuperSmartParkingBoy = new SuperSmartParkingBoy(Collections.singletonList(new ParkingLot()));
        ParkingTicket parkingTicket = superSuperSmartParkingBoy.park(car);

        // When
        Car actualCar = superSuperSmartParkingBoy.fetch(parkingTicket);

        // Then
        assertSame(car, actualCar);
    }

//    Given a parking lot with two parked cars, a super smart parking boy, and two parking tickets
//    When fetch the car twice
//    Then return the right car with each ticket
    @Test
    void should_return_the_right_car_when_fetch_twice_given_a_parking_lot_with_two_parked_cars_and_a_smart_parking_boy_and_two_parking_tickets() {
        // Given
        Car firstCar = new Car();
        Car secondCar = new Car();
        SuperSmartParkingBoy superSuperSmartParkingBoy = new SuperSmartParkingBoy(Collections.singletonList(new ParkingLot()));
        ParkingTicket firstParkingTicket = superSuperSmartParkingBoy.park(firstCar);
        ParkingTicket secondParkingTicket = superSuperSmartParkingBoy.park(secondCar);

        // When
        Car firstFetchedCar = superSuperSmartParkingBoy.fetch(firstParkingTicket);
        Car secondFetchedCar = superSuperSmartParkingBoy.fetch(secondParkingTicket);

        // Then
        assertSame(firstCar, firstFetchedCar);
        assertSame(secondCar, secondFetchedCar);

    }

//    Given a parking lot, a super smart parking boy, and a wrong parking ticket
//    When fetch the car
//    Then return nothing with error message "Unrecognized parking ticket."
    @Test
    void should_return_no_car_with_error_message_when_fetch_given_a_parking_lot_and_a_smart_parking_boy_and_a_wrong_parking_ticket() {
        // Given
        Car car = new Car();
        SuperSmartParkingBoy superSuperSmartParkingBoy = new SuperSmartParkingBoy(Collections.singletonList(new ParkingLot()));
        superSuperSmartParkingBoy.park(car);
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();

        // When
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> superSuperSmartParkingBoy.fetch(unrecognizedParkingTicket));

        // Then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

//    Given a parking lot, a super smart parking boy, and a used parking ticket
//    When fetch the car
//    Then return nothing with error message "Unrecognized parking ticket."
    @Test
    void should_return_no_car_with_error_message_when_fetch_given_a_parking_lot_and_a_smart_parking_boy_and_a_used_parking_ticket() {
        // Given
        Car car = new Car();
        SuperSmartParkingBoy superSuperSmartParkingBoy = new SuperSmartParkingBoy(Collections.singletonList(new ParkingLot()));
        ParkingTicket parkingTicket = superSuperSmartParkingBoy.park(car);
        superSuperSmartParkingBoy.fetch(parkingTicket);

        // When
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> superSuperSmartParkingBoy.fetch(parkingTicket));

        // Then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

//    Given a parking lot without any position, a super smart parking boy, and a car
//    When park the car
//    Then return nothing with error message "No available position."
    @Test
    void should_return_no_parking_ticket_with_error_message_when_park_given_a_parking_lot_without_any_position_and_a_smart_parking_boy_and_a_car() {
        // Given
        SuperSmartParkingBoy superSuperSmartParkingBoy = new SuperSmartParkingBoy(Collections.singletonList(new ParkingLot()));
        for (int i = 0; i < 10; i++) {
            superSuperSmartParkingBoy.park(new Car());
        }

        Car eleventhCar = new Car();

        // When
        Exception exception = assertThrows(NoAvailablePositionException.class, () -> superSuperSmartParkingBoy.park(eleventhCar));

        // Then
        assertEquals("No available position.", exception.getMessage());

    }

//    Given a super smart parking boy, who manage two parking lots, both with available position, and a car
//    When park the car
//    Then the car will park to the parking lot which has a larger available position rate
    @Test
    void should_park_in_parking_lot_which_has_larger_available_position_rate_when_park_given_a_smart_parking_boy_who_manage_two_parking_lots_both_with_available_position() {
        // Given
        Car car = new Car();
        SuperSmartParkingBoy superSuperSmartParkingBoy = new SuperSmartParkingBoy(asList(new ParkingLot(15), new ParkingLot(20)));

        //Park 3 cars in both parking lot
        for (int i = 0; i < 3; i++) {
            superSuperSmartParkingBoy.getParkingLotList().get(0).park(new Car());
            superSuperSmartParkingBoy.getParkingLotList().get(1).park(new Car());
        }

        // When
        superSuperSmartParkingBoy.park(car);

        // Then
        assertEquals(4, superSuperSmartParkingBoy.getParkingLotList().get(1).getCountParkedCars());
    }
}
