package strategy;

import models.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyPricingStrategy implements PricingStrategy{
    private static final double BASE_HOURLY_RATE = 20.0;

    @Override
    public double calulatePrice(Ticket ticket) {
        LocalDateTime endTime = LocalDateTime.now();
        long hours = Duration.between(ticket.getStartTime(), endTime).toHours();

        // Charge for at least 1 hour
        if (hours < 1) hours = 1;

        return hours * BASE_HOURLY_RATE;
    }
}
