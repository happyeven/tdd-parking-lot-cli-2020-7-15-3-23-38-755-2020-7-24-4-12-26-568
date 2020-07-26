package com.oocl.cultivation;

import java.util.List;

/**
 * @Author ZHUDO2
 * @Date 7/24/2020 4:33 PM
 * @Version 1.0
 */
public class ParkingBoy {
    private ParkingLot parkingLot;
    private List<ParkingLot> parkingLots;
    private String errorMessage = "Unrecognized parking ticket.";

    public ParkingBoy(ParkingLot... parkingLots) {
        for(ParkingLot parkingLot : parkingLots){
            this.parkingLots.add(parkingLot);
        }
        this.parkingLot = this.parkingLots.get(0);
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    Ticket parkingCar(Car car) {
        if(car == null){
            return null;
        }
        Ticket ticket = this.parkingLot.parkingCarTOParkingLot(car);
        if(ticket == null){
            this.errorMessage = "Not enough position.";
        }
        return ticket;
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
