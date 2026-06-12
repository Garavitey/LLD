package repository;

import models.Ticket;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryTicketRepository implements TicketRepository {
    // Our in-memory database table for tickets
    private final Map<String, Ticket> database = new HashMap<>();

    @Override
    public Ticket save(Ticket ticket) {
        // Save the ticket using its pre-generated ID as the key
        database.put(ticket.getTicketId(), ticket);
        return ticket;
    }

    @Override
    public Optional<Ticket> findById(String ticketId) {
        // Retrieve the ticket from the map
        Ticket ticket = database.get(ticketId);

        // Wrap it in an Optional. If ticket is null, it safely returns Optional.empty()
        return Optional.ofNullable(ticket);
    }
}