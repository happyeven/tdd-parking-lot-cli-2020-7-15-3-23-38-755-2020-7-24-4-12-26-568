package com.oocl.cultivation;

import java.util.List;

public interface ParkingBoyStrategy {
    ParkingLot selectParkingLot(List<ParkingLot> parkingLots);
}
