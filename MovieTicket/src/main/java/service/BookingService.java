package service;

import enums.BookingStatus;
import enums.SeatType;
import Models.Booking;
import Models.Show;
import Models.ShowSeat;
import repository.ShowRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BookingService {
    private final ShowRepository showRepository;
    private final Map<String, Booking> bookingDatabase = new HashMap<>(); // In-memory booking storage

    public BookingService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    public Booking bookTickets(String userId, String showId, List<String> requestedPhysicalSeatIds) {
        // 1. Fetch the show time slot instance
        Show show = showRepository.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show not found!"));

        List<ShowSeat> seatsToBook = new ArrayList<>();

        // 2. Validate availability of all requested seats
        for (String seatId : requestedPhysicalSeatIds) {
            ShowSeat showSeat = show.getShowSeats().stream()
                    .filter(ss -> ss.getPhysicalSeat().getSeatId().equals(seatId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Seat " + seatId + " does not exist in this auditorium!"));

            if (showSeat.isBooked()) {
                throw new RuntimeException("Seat " + seatId + " is already booked by another user!");
            }
            seatsToBook.add(showSeat);
        }

        // 3. Mark the dynamic show seats as booked
        for (ShowSeat seat : seatsToBook) {
            seat.setBooked(true);
        }

        // 4. Save the modified show state back to our data layer
        showRepository.save(show);

        // 5. Calculate a mock total price based on seat classifications
        double totalAmount = calculatePrice(seatsToBook);

        // 6. Generate the confirmation ticket
        String generatedBookingId = "BKG-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        Booking booking = new Booking(generatedBookingId, userId, show, seatsToBook, totalAmount);
        booking.setBookingStatus(BookingStatus.CONFIRMED); // Directly confirm it for this phase

        bookingDatabase.put(generatedBookingId, booking);
        return booking;
    }

    private double calculatePrice(List<ShowSeat> seats) {
        double total = 0;
        for (ShowSeat seat : seats) {
            if (seat.getPhysicalSeat().getSeatType() == SeatType.VIP) {
                total += 500.0; // Premium price pricing strategy
            } else {
                total += 250.0; // Base normal pricing
            }
        }
        return total;
    }

    public Booking getBookingDetails(String bookingId) {
        if (!bookingDatabase.containsKey(bookingId)) {
            throw new RuntimeException("Ticket reference not found!");
        }
        return bookingDatabase.get(bookingId);
    }
}