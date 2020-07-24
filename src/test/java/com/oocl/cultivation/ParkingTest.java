package com.oocl.cultivation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author ZHUDO2
 * @Date 7/24/2020 4:28 PM
 * @Version 1.0
 */
public class ParkingTest {
    @Test
    void should_return_ticket_when_parking_boy_parking_car_given_car_and_parking_boy() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        Car car = new Car(1);
        //when
        Ticket ticket = parkingBoy.parkingCar(car);
        //then
        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_return_correct_car_when_fetch_car_given_ticket_and_parking_boy_and_car() {
        //given
        int token = 1;
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        Car car = new Car(token);
        Ticket ticket = parkingBoy.parkingCar(car);
        //when
        Car resultCar = parkingBoy.fetchingCar(ticket);
        //then
        Assertions.assertEquals(car.getCarId(), resultCar.getCarId());
    }

    @Test
    void should_return_2_ticket_when_parking_boy_parking_car_given_2_car_and_parking_boy() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        Car firstCar = new Car(1);
        Car secondCar = new Car(2);
        //when
        Ticket firstTicket = parkingBoy.parkingCar(firstCar);
        Ticket secondTicket = parkingBoy.parkingCar(secondCar);
        //then
        Assertions.assertNotNull(firstTicket);
        Assertions.assertNotNull(secondTicket);
    }

    @Test
    void should_return_2_car_when_fetch_car_given_2_ticket_and_parking_boy_and_2_car() {
        //given
        int firstToken = 1;
        int secondToken = 2;
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        Car firstTargetCar = new Car(firstToken);
        Car secondTargetCar = new Car(secondToken);
        Ticket firstTicket = parkingBoy.parkingCar(firstTargetCar);
        Ticket secondTicket = parkingBoy.parkingCar(secondTargetCar);
        //when
        Car firstFetchingCar = parkingBoy.fetchingCar(firstTicket);
        Car secondFetchingCar = parkingBoy.fetchingCar(secondTicket);
        //then
        Assertions.assertEquals(firstTargetCar, firstFetchingCar);
        Assertions.assertEquals(secondTargetCar, secondFetchingCar);
    }

    @Test
    void should_return_null_when_parking_car_given_wrong_ticket_and_parking_boy() {
        //given
        int token = 20;
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        Ticket wrongTicket = new Ticket(token);
        //when
        Car fetchingCar = parkingBoy.fetchingCar(wrongTicket);
        //then
        Assertions.assertNull(fetchingCar);
    }

    @Test
    void should_return_null_when_parking_car_given_used_ticket_and_parking_boy() {
        //given
        int token = 20;
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        Ticket ticket = new Ticket(token);
        Car firstCar = parkingBoy.fetchingCar(ticket);
        //when
        Car secondCar = parkingBoy.fetchingCar(ticket);
        //then
        Assertions.assertNull(secondCar);
    }

    @Test
    void should_return_null_when_parking_boy_parking_car_given_car_and_parking_lot_has_no_position() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        int parkingCarIndex = 0;
        for ( ; parkingCarIndex < 10; parkingCarIndex++) {
            parkingBoy.parkingCar(new Car(parkingCarIndex));
        }
        //when
        Ticket ticket = parkingBoy.parkingCar(new Car(parkingCarIndex));
        //then
        Assertions.assertNull(ticket);
    }

    @Test
    void should_return_null_when_parking_boy_fetch_car_given_no_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        Car car = parkingBoy.fetchingCarWithoutTicket();
        //then
        Assertions.assertNull(car);
    }

    @Test
    void should_return_null_when_parking_boy_parking_car_given_car_is_null() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = null;
        //when
        Ticket ticket = parkingBoy.parkingCar(car);
        //then
        Assertions.assertNull(ticket);
    }
}
