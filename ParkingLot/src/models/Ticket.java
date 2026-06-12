package models;

import java.time.LocalDateTime;

public class Ticket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot allocatedSpot;
    private final LocalDateTime startTime;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot allocatedSpot) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.allocatedSpot = allocatedSpot;
        this.startTime = LocalDateTime.now();
    }

    public String getTicketId() { return ticketId; }
    public Vehicle getVehicle() { return vehicle; }
    public ParkingSpot getAllocatedSpot() { return allocatedSpot; }
    public LocalDateTime getStartTime() { return startTime; }
}
