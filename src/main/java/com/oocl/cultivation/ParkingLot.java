package com.oocl.cultivation;

import java.util.HashMap;

public class ParkingLot {
    private int capacity = 10;
    private int availableCapacity = 10;
    private HashMap<Ticket, Car> parkingCars = new HashMap<>();

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setAvailableCapacity(int availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

    public int getAvailableCapacity() {
        return availableCapacity;
    }

    public Ticket parkingCarToParkingLot(Car car) {
        if (availableCapacity == 0) {
            return null;
        }
        Ticket ticket = new Ticket(car.getCarId());
        this.parkingCars.put(ticket, car);
        availableCapacity--;
        return ticket;
    }

    public int getCapacity() {
        return capacity;
    }

    public Car fetchingCarFromParkingLot(Ticket ticket) {
        this.availableCapacity++;
        return this.parkingCars.remove(ticket);
    }
}
