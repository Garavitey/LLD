package repository;

import models.Ticket;
import java.util.Optional;

public interface TicketRepository {
    Ticket save(Ticket ticket);
    Optional<Ticket> findById(String ticketId);
}