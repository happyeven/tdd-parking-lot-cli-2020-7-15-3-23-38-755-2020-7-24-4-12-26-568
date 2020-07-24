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
        ParkingBoy parkingBoy = new ParkingBoy();
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
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = new Ticket(token);
        Car car = new Car(token);
        //when
        Car resultCar = parkingBoy.fetchingCar(ticket);
        //then
        Assertions.assertEquals(car.getCarId(), resultCar.getCarId());
    }

    @Test
    void should_return_2_ticket_when_parking_boy_parking_car_given_2_car_and_parking_boy() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
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
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket firstTicket = new Ticket(firstToken);
        Ticket secondTicket = new Ticket(secondToken);
        Car firstTargetCar = new Car(firstToken);
        Car secondTargetCar = new Car(secondToken);
        //when
        Car firstFetchingCar = parkingBoy.fetchingCar(firstTicket);
        Car secondFetchingCar = parkingBoy.fetchingCar(secondTicket);
        //then
        Assertions.assertEquals(firstTargetCar,firstFetchingCar);
        Assertions.assertEquals(secondTargetCar,secondFetchingCar);

    }
}
