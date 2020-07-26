package com.oocl.cultivation;

import java.util.LinkedList;
import java.util.List;

public class ParkingLotServiceManager {
    private List<ParkingBoyStrategy> parkingBoys = new LinkedList<>();

    public ParkingLotServiceManager(ParkingBoyStrategy... parkingBoyStrategies) {
        for(ParkingBoyStrategy parkingBoyStrategy : parkingBoyStrategies){
            parkingBoys.add(parkingBoyStrategy);
        }
    }

    public Ticket specifyParkingBoyToParkingCar(ParkingBoy parkingBoy, Car car) {
        if(this.parkingBoys.size() == 0){
            return null;
        }
        if(this.parkingBoys.contains(parkingBoy)){
            return parkingBoy.parkingCar(car);
        }
        return null;
    }

    public Car specifyParkingBoyToFetchingCar(ParkingBoy parkingBoy, Ticket ticket) {
        return null;
    }
}
