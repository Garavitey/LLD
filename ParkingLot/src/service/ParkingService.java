package service;

import enums.VehicleType;
import models.ParkingLot;
import models.ParkingSpot;
import models.Ticket;
import models.Vehicle;
import repository.ParkingLotRepository;
import repository.TicketRepository;
import strategy.PricingStrategy;
import strategy.SpotAllocationStrategy;

import java.util.Optional;
import java.util.UUID;

public class ParkingService {
    // 1. Swapped spotRepository for lotRepository to fetch the whole multi-floor building
    private final ParkingLotRepository lotRepository;
    private final TicketRepository ticketRepository;
    private final SpotAllocationStrategy allocationStrategy;
    private final PricingStrategy pricingStrategy;

    public ParkingService(ParkingLotRepository lotRepository,
                          TicketRepository ticketRepository,
                          SpotAllocationStrategy allocationStrategy,
                          PricingStrategy pricingStrategy) {
        this.lotRepository = lotRepository;
        this.ticketRepository = ticketRepository;
        this.allocationStrategy = allocationStrategy;
        this.pricingStrategy = pricingStrategy;
    }

    public Ticket issueTicket(String parkingLotId, String licensePlate, VehicleType vehicleType) {
        // 2. Look up the entire parking lot from our database
        ParkingLot lot = lotRepository.findById(parkingLotId)
                .orElseThrow(() -> new RuntimeException("Error: Parking Lot not found with ID: " + parkingLotId));

        // 3. Pass the structured FLOORS to our allocation strategy
        Optional<ParkingSpot> allocatedSpotOpt = allocationStrategy.findSpot(vehicleType, lot.getFloors());

        if (allocatedSpotOpt.isEmpty()) {
            throw new RuntimeException("Gate Denied: No available parking space for " + vehicleType);
        }

        ParkingSpot spot = allocatedSpotOpt.get();
        Vehicle vehicle = new Vehicle(licensePlate, vehicleType);
        spot.parkVehicle(vehicle);

        // 4. Save the entire updated parking lot structure back to the database
        lotRepository.save(lot);

        String ticketId = "TKT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        Ticket ticket = new Ticket(ticketId, vehicle, spot);

        return ticketRepository.save(ticket);
    }

    public double checkOut(String ticketId) {
        // 5. Fetch the ticket to handle the driver leaving
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Error: Invalid Ticket ID " + ticketId));

        // 6. Compute fees using our active strategy rule
        double amountDue = pricingStrategy.calulatePrice(ticket);

        // 7. Clear the spot, marking it available again
        ParkingSpot spot = ticket.getAllocatedSpot();
        spot.vacateSpot();

        // 8. Since the spot lives deep inside a floor of a lot, we save the lot to flush updates to our database
        // In a real database setup, you could target the spot explicitly, but this works beautifully for aggregate roots.
        ticketRepository.save(ticket);

        System.out.println("Success: Vehicle " + ticket.getVehicle().getLicensePlate() +
                " cleared spot " + spot.getSpotId() +
                ". Total Fee Collected: Rs. " + amountDue);

        return amountDue;
    }
}