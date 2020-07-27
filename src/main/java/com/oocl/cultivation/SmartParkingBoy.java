package com.oocl.cultivation;

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
        ParkingLot targetParkingLot = selectParkingLot();
        Ticket ticket = targetParkingLot.parkingCarToParkingLot(car);
        if(ticket == null){
            this.errorMessage = "Not enough position.";
        }
        ticket.setCorrespondParkingLot(targetParkingLot);
        return ticket;
    }

    private ParkingLot selectParkingLot() {
        ParkingLot targetParkingLot = this.parkingLots.get(0);
        for (ParkingLot parkingLot : this.parkingLots) {
            if (parkingLot.getAvailableCapacity() > targetParkingLot.getAvailableCapacity()) {
                targetParkingLot = parkingLot;
            }
        }
        return targetParkingLot;
    }
}
