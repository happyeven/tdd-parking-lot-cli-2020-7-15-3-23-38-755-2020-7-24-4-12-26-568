package com.oocl.cultivation;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author ZHUDO2
 * @Date 7/24/2020 4:33 PM
 * @Version 1.0
 */
public class ParkingBoy implements ParkingBoyStrategy {
    List<ParkingLot> parkingLots = new LinkedList<>();
    String errorMessage;

    public ParkingBoy(ParkingLot... parkingLots) {
        for (ParkingLot parkingLot : parkingLots) {
            this.parkingLots.add(parkingLot);
        }
    }

    @Override
    public Ticket parkingCar(Car car) {
        if (car == null) {
            return null;
        }
        if (this.parkingLots.size() != 0) {
            for (ParkingLot parkingLot : this.parkingLots) {
                if (parkingLot.getAvailableCapacity() != 0) {
                    Ticket ticket = parkingLot.parkingCarToParkingLot(car);
                    ticket.setCorrespondParkingLot(parkingLot);
                    return ticket;
                }
            }
        }
        this.errorMessage = "Not enough position.";
        return null;
    }

    @Override
    public Car fetchingCar(Ticket ticket) {
        if (ticket == null) {
            return null;
            if (this.parkingLots.size() == 0) {
                return null;
            }
            for (ParkingLot parkingLot : this.parkingLots) {
                Car car = parkingLot.fetchingCarFromParkingLot(ticket);
                if (car != null) {
                    return car;
                }
            }
            this.errorMessage = "Unrecognized parking ticket.";
            return null;
        }

        public Car fetchingCarWithoutTicket () {//todo
            this.errorMessage = "Please provide your parking ticket.";
            return null;
        }

        public String queryErrorMessage () {
            return this.errorMessage;
        }
    }
