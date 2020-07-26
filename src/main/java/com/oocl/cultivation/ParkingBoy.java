package com.oocl.cultivation;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author ZHUDO2
 * @Date 7/24/2020 4:33 PM
 * @Version 1.0
 */
public class ParkingBoy {
    List<ParkingLot> parkingLots = new LinkedList<>();
    String errorMessage;

    public ParkingBoy(ParkingLot... parkingLots) {
        for (ParkingLot parkingLot : parkingLots) {
            this.parkingLots.add(parkingLot);
        }
    }

    Ticket parkingCar(Car car) {
        if (car == null) {
            return null;
        }
        for (ParkingLot parkingLot : this.parkingLots) {
            if (parkingLot.getAvailableCapacity() != 0) {
                Ticket ticket = parkingLot.parkingCarTOParkingLot(car);
                ticket.setCorrespondParkingLot(parkingLot);
                return ticket;
            }
        }
        this.errorMessage = "Not enough position.";
        return null;
    }

    public Car fetchingCar(Ticket ticket) {
        for (ParkingLot parkingLot : this.parkingLots) {
            Car car = parkingLot.fetchingCarFromParkingLot(ticket);
            if (car != null) {
                return car;
            }
        }
        this.errorMessage = "Unrecognized parking ticket.";
        return null;
    }

    public Car fetchingCarWithoutTicket() {
        this.errorMessage = "Please provide your parking ticket.";
        return null;
    }

    public String queryErrorMessage() {
        return this.errorMessage;
    }
}
