package com.oocl.cultivation;

import java.util.LinkedList;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy implements ParkingBoyStrategy{
    public SmartParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket parkingCar(Car car) {
        if (car == null) {
            return null;
        }
        if(this.parkingLots.size() == 0){
            return null;
        }
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
        if(ticket == null){
            this.errorMessage = "Not enough position.";
        }
        ticket.setCorrespondParkingLot(targetParkingLot);
        return ticket;
    }
}
