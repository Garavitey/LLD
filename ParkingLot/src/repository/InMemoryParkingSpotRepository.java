package repository;

import models.ParkingSpot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryParkingSpotRepository implements ParkingSpotRepository {
    private final Map<String, ParkingSpot> database = new HashMap<>();

    @Override
    public ParkingSpot save(ParkingSpot spot) {
        // Write the save logic here using .put()
        return null;
    }

    @Override
    public Optional<ParkingSpot> findById(String spotId) {
        // Write the findById logic here using Optional.ofNullable()
        return Optional.empty();
    }

    @Override
    public List<ParkingSpot> findAll() {
        // Return all parking spots currently stored in the map as a List
        // Hint: database.values() gets the values, but you need to wrap it in a new ArrayList<>
        return null;
    }
}