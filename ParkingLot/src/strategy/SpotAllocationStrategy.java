package strategy;

import enums.VehicleType;
import models.ParkingFloor;
import models.ParkingSpot;
import java.util.List;
import java.util.Optional;

public interface SpotAllocationStrategy {
    /**
     * Looks through all floors to find a matching, un-occupied parking spot.
     * Returns an Optional.empty() if the lot is completely full for this vehicle type.
     */
    Optional<ParkingSpot> findSpot(VehicleType vehicleType, List<ParkingFloor> floors);
}