package com.oocl.cultivation;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    @Override
    Ticket parkingCar(Car car) {
        double maxAvailablePositionRate = 0;
        if(this.parkingLots.size() == 0){
            return null;
        }
        ParkingLot targetParkingLot = parkingLots.get(0);
        for (ParkingLot parkingLot : parkingLots) {
            double availablePositionRate = (double) parkingLot.getAvailableCapacity() /
                    parkingLot.getCapacity();
            if (availablePositionRate > maxAvailablePositionRate) {
                maxAvailablePositionRate = availablePositionRate;
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
