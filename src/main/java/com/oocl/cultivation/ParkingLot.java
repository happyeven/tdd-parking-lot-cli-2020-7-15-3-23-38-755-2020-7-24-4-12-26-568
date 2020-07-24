package com.oocl.cultivation;

import java.util.HashMap;

public class ParkingLot {
    HashMap<Ticket,Car> parkingCars = new HashMap<>();

    public Ticket parkingCarTOParkingLot(Car car){
        Ticket ticket = new Ticket(car.getCarId());
        this.parkingCars.put(ticket,car);
        return ticket;
    }
    public Car fetchingCarFromParkingLot(Ticket ticket){
        return this.parkingCars.get(ticket);
    }
}
