package com.oocl.cultivation;

/**
 * @Author ZHUDO2
 * @Date 7/24/2020 4:33 PM
 * @Version 1.0
 */
public class ParkingBoy {
    private ParkingLot parkingLot;
    private String errorMessage = "Unrecognized parking ticket.";

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
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
