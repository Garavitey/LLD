package strategy;

import models.Ticket;

public interface PricingStrategy {
    double calulatePrice(Ticket ticket);

}
