package com.oocl.cultivation;

/**
 * @Author ZHUDO2
 * @Date 7/24/2020 3:56 PM
 * @Version 1.0
 */
public class Ticket {
    private int ticketId;

    private ParkingLot correspondParkingLot;

    public int getTicketId() {
        return ticketId;
    }

    public Ticket(int ticketId) {
        this.ticketId = ticketId;
    }

    public void setCorrespondParkingLot(ParkingLot correspondParkingLot) {
        this.correspondParkingLot = correspondParkingLot;
    }

    public ParkingLot getCorrespondParkingLot() {
        return correspondParkingLot;
    }
}
