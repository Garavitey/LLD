package models;

import java.util.List;

public class ParkingLot {
    private final String parkingLotId;
    private final List<ParkingFloor> floors;

    public ParkingLot(String parkingLotId, List<ParkingFloor> floors) {
        this.parkingLotId = parkingLotId;
        this.floors = floors;
    }

    public String getParkingLotId() { return parkingLotId; }
    public List<ParkingFloor> getFloors() { return floors; }
}