package com.oocl.cultivation;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy implements ParkingBoyStrategy {
    public SuperSmartParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket parkingCar(Car car) {// todo extract a strategy
        double maxAvailablePositionRate = 0;
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
        ParkingLot targetParkingLot = parkingLots.get(0);
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getAvailablePositionRate() > targetParkingLot.getAvailablePositionRate()) {
                targetParkingLot = parkingLot;
            }
        }
        return targetParkingLot;
    }
}
