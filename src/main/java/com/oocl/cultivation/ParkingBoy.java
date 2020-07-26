package com.oocl.cultivation;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author ZHUDO2
 * @Date 7/24/2020 4:33 PM
 * @Version 1.0
 */
public class ParkingBoy {
    private ParkingLot parkingLot;
    private List<ParkingLot> parkingLots = new LinkedList<>();
    private String errorMessage = "Unrecognized parking ticket.";

    public ParkingBoy(ParkingLot... parkingLots) {
        for (ParkingLot parkingLot : parkingLots) {
            this.parkingLots.add(parkingLot);
        }
        this.parkingLot = this.parkingLots.get(0);
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    Ticket parkingCar(Car car) {
        if (car == null) {
            return null;
        }
        for (ParkingLot parkingLot : this.parkingLots) {
            if (parkingLot.getAvailableCapacity() != 0) {
                return parkingLot.parkingCarTOParkingLot(car);
            }
        }
        this.errorMessage = "Not enough position.";
        return null;
    }

    public Car fetchingCar(Ticket ticket) {
        return this.parkingLot.fetchingCarFromParkingLot(ticket);
    }

    public Car fetchingCarWithoutTicket() {
        this.errorMessage = "Please provide your parking ticket.";
        return null;
    }

    public String queryErrorMessage() {
        return this.errorMessage;
    }
}
