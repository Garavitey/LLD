package strategy;

import enums.SpotType;
import enums.VehicleType;
import models.ParkingFloor;
import models.ParkingSpot;
import java.util.List;
import java.util.Optional;

public class DefaultAllocationStrategy implements SpotAllocationStrategy {

    @Override
    public Optional<ParkingSpot> findSpot(VehicleType vehicleType, List<ParkingFloor> floors) {
        // 1. Get the cascading list of allowable spots for this specific vehicle type
        List<SpotType> preferredTypes = getPreferredSpotTypes(vehicleType);

        // 2. Prioritize by optimal spot matching first
        for (SpotType allowedType : preferredTypes) {

            // 3. Search floor-by-floor (starting at Floor 1, moving upwards)
            for (ParkingFloor floor : floors) {
                Optional<ParkingSpot> availableSpot = floor.getSpots().stream()
                        .filter(spot -> !spot.isOccupied())
                        .filter(spot -> spot.getSpotType() == allowedType)
                        .findFirst();

                if (availableSpot.isPresent()) {
                    return availableSpot; // Instantly return the moment a match is found
                }
            }
        }

        // 4. Return an empty box if we parsed every single spot on every floor and found nothing
        return Optional.empty();
    }

    /**
     * Captures the fallback matrix logic (Requirement #7).
     * Defines exactly what sizes a vehicle can upscale into.
     */
    private List<SpotType> getPreferredSpotTypes(VehicleType vehicleType) {
        return switch (vehicleType) {
            case BIKE -> List.of(SpotType.MOTORBIKE, SpotType.COMPACT, SpotType.LARGE);
            case CAR -> List.of(SpotType.COMPACT, SpotType.LARGE);
            case EV_CAR -> List.of(SpotType.ELECTRIC, SpotType.COMPACT, SpotType.LARGE);
            case TRUCK -> List.of(SpotType.LARGE); // Trucks can strictly only fit in Large slots
        };
    }
}