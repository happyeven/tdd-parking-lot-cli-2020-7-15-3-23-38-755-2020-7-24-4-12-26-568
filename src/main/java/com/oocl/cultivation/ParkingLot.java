package com.oocl.cultivation;

import java.util.HashMap;

public class ParkingLot {
    int capacity = 10;
    HashMap<Ticket, Car> parkingCars = new HashMap<>();
    String errorMessage;

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Ticket parkingCarTOParkingLot(Car car) {
        if (capacity == 0) {
            return null;
        }
        Ticket ticket = new Ticket(car.getCarId());
        this.parkingCars.put(ticket, car);
        capacity--;
        return ticket;
    }

    public Car fetchingCarFromParkingLot(Ticket ticket) {
        return this.parkingCars.remove(ticket);
    }
}
