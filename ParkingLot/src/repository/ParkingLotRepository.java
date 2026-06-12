package repository;

import models.ParkingLot;
import java.util.Optional;

public interface ParkingLotRepository {
    ParkingLot save(ParkingLot parkingLot);
    Optional<ParkingLot> findById(String id);
}