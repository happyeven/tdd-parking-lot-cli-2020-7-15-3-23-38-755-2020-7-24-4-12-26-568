package com.oocl.cultivation;

/**
 * @Author ZHUDO2
 * @Date 7/24/2020 4:33 PM
 * @Version 1.0
 */
public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    Ticket parkingCar(Car car) {
        return this.parkingLot.parkingCarTOParkingLot(car);
    }

    public Car fetchingCar(Ticket ticket) {
        return this.parkingLot.fetchingCarFromParkingLot(ticket);
    }
}
