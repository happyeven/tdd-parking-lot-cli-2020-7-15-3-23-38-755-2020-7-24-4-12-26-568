package com.oocl.cultivation;

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
        ParkingLot targetParkingLot = parkingLots.get(0);
        for (ParkingLot parkingLot : parkingLots) {
            double availablePositionRate = parkingLot.getAvailablePositionRate();
            if (availablePositionRate > maxAvailablePositionRate) {
                maxAvailablePositionRate = availablePositionRate;
                targetParkingLot = parkingLot;
            }
        }
        Ticket ticket = targetParkingLot.parkingCarToParkingLot(car);
        if (ticket == null) {
            this.errorMessage = "Not enough position.";
        }
        ticket.setCorrespondParkingLot(targetParkingLot);
        return ticket;
    }
}
