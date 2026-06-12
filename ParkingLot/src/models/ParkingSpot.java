package models;

import enums.SpotType;

public class ParkingSpot {
    private final String spotId;
    private final int floorNumber;
    private final SpotType spotType;
    private boolean isOccupied;
    private Vehicle parkedVehicle;

    public ParkingSpot(String spotId, int floorNumber, SpotType spotType) {
        this.spotId = spotId;
        this.floorNumber = floorNumber;
        this.spotType = spotType;
        this.isOccupied = false;
        this.parkedVehicle = null;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.isOccupied = true;
    }

    public void vacateSpot() {
        this.parkedVehicle = null;
        this.isOccupied = false;
    }

    // Getters
    public String getSpotId() { return spotId; }
    public int getFloorNumber() { return floorNumber; }
    public SpotType getSpotType() { return spotType; }
    public boolean isOccupied() { return isOccupied; }
    public Vehicle getParkedVehicle() { return parkedVehicle; }
}