package com.oocl.cultivation;

/**
 * @Author ZHUDO2
 * @Date 7/24/2020 4:33 PM
 * @Version 1.0
 */
public class ParkingBoy {
    Ticket parkingCar(Car car) {
        return new Ticket(car.getCarId());
    }
}
