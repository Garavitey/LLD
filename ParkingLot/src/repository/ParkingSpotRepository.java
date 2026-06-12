package repository;

import models.ParkingSpot;
import java.util.List;
import java.util.Optional;

public interface ParkingSpotRepository {
    ParkingSpot save(ParkingSpot spot);
    Optional<ParkingSpot> findById(String spotId);
    List<ParkingSpot> findAll();
}