package com.oocl.cultivation;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy implements ParkingBoyStrategy {
    public SmartParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket parkingCar(Car car) {
        if (car == null) {
            return null;
        }
        if (this.parkingLots.size() == 0) {
            return null;
        }
        ParkingLot targetParkingLot = selectParkingLot(this.parkingLots);
        Ticket ticket = targetParkingLot.parkingCarToParkingLot(car);
        if (ticket == null) {
            this.errorMessage = "Not enough position.";
        }
        ticket.setCorrespondParkingLot(targetParkingLot);
        return ticket;
    }

    @Override
    public ParkingLot selectParkingLot(List<ParkingLot> parkingLots) {
        ParkingLot targetParkingLot = this.parkingLots.get(0);
        for (ParkingLot parkingLot : this.parkingLots) {
            if (parkingLot.getAvailableCapacity() > targetParkingLot.getAvailableCapacity()) {
                targetParkingLot = parkingLot;
            }
        }
        return targetParkingLot;
    }
}
