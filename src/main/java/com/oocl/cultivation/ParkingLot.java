package com.oocl.cultivation;

import java.util.HashMap;

public class ParkingLot {
    private int availableCapacity = 10;
    private HashMap<Ticket, Car> parkingCars = new HashMap<>();

    public void setCapacity(int availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

    public Ticket parkingCarTOParkingLot(Car car) {
        if (availableCapacity == 0) {
            return null;
        }
        Ticket ticket = new Ticket(car.getCarId());
        this.parkingCars.put(ticket, car);
        availableCapacity--;
        return ticket;
    }

    public Car fetchingCarFromParkingLot(Ticket ticket) {
        return this.parkingCars.remove(ticket);
    }
}
