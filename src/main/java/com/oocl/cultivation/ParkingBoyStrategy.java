package com.oocl.cultivation;

public interface ParkingBoyStrategy {
    Car fetchingCar(Ticket ticket);
    Ticket parkingCar(Car car);
}
