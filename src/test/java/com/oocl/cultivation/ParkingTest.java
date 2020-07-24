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


}
