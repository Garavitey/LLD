package repository;

import models.ParkingLot;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryParkingLotRepository implements ParkingLotRepository {
    private final Map<String, ParkingLot> database = new HashMap<>();

    @Override
    public ParkingLot save(ParkingLot parkingLot) {
        database.put(parkingLot.getParkingLotId(), parkingLot);
        return parkingLot;
    }

    @Override
    public Optional<ParkingLot> findById(String id) {
        return Optional.ofNullable(database.get(id));
    }
}