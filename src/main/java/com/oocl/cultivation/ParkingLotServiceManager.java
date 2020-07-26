package com.oocl.cultivation;

import java.util.LinkedList;
import java.util.List;

public class ParkingLotServiceManager {
    private List<ParkingBoyStrategy> parkingBoys = new LinkedList<>();
    private List<ParkingLot> parkingLotList = new LinkedList<>();

    public ParkingLotServiceManager(ParkingBoyStrategy... parkingBoyStrategies) {
        for (ParkingBoyStrategy parkingBoyStrategy : parkingBoyStrategies) {
            parkingBoys.add(parkingBoyStrategy);
        }
    }

    public Ticket specifyParkingBoyToParkingCar(ParkingBoy parkingBoy, Car car) {
        if (this.parkingBoys.size() == 0) {
            return null;
        }
        if (this.parkingBoys.contains(parkingBoy)) {
            return parkingBoy.parkingCar(car);
        }
        return null;
    }

    public Car specifyParkingBoyToFetchingCar(ParkingBoy parkingBoy, Ticket ticket) {
        if (this.parkingBoys.size() == 0) {
            return null;
        }
        if (this.parkingBoys.contains(parkingBoy)) {
            return parkingBoy.fetchingCar(ticket);
        }
        return null;
    }

    public Ticket parkingCar(Car car) {
        if (car == null) {
            return null;
        }
        if (this.parkingLotList.size() != 0) {
            for (ParkingLot parkingLot : this.parkingLotList) {
                if (parkingLot.getAvailableCapacity() != 0) {
                    Ticket ticket = parkingLot.parkingCarTOParkingLot(car);
                    ticket.setCorrespondParkingLot(parkingLot);
                    return ticket;
                }
            }
        }
        return null;
    }

    public void setParkingLot(ParkingLot... parkingLots) {
        for (ParkingLot parkingLot : parkingLots) {
            this.parkingLotList.add(parkingLot);
        }
    }
}
