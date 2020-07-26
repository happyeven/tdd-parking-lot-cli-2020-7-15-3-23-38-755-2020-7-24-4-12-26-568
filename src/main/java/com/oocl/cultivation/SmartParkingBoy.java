package com.oocl.cultivation;

import java.util.LinkedList;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    @Override
    Ticket parkingCar(Car car) {
        ParkingLot targetParkingLot = this.parkingLots.get(0);
        int maxAvailableCapacity = targetParkingLot.getAvailableCapacity();
        for (ParkingLot parkingLot : this.parkingLots) {
            int availableCapacity = parkingLot.getAvailableCapacity();
            if (availableCapacity > maxAvailableCapacity) {
                maxAvailableCapacity = availableCapacity;
                targetParkingLot = parkingLot;
            }
        }
        Ticket ticket = targetParkingLot.parkingCarTOParkingLot(car);
        ticket.setCorrespondParkingLot(targetParkingLot);
        return ticket;
    }
}
