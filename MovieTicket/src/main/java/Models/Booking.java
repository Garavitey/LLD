package Models;

import enums.BookingStatus;
import java.util.List;

public class Booking {
    private final String bookingId;
    private final String userId;
    private final Show show;
    private final List<ShowSeat> bookedSeats;
    private final double totalAmount;
    private BookingStatus bookingStatus;

    public Booking(String bookingId, String userId, Show show, List<ShowSeat> bookedSeats, double totalAmount) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.show = show;
        this.bookedSeats = bookedSeats;
        this.totalAmount = totalAmount;
        this.bookingStatus = BookingStatus.PENDING; // Starts as pending until payment is mock-confirmed
    }

    public String getBookingId() { return bookingId; }
    public String getUserId() { return userId; }
    public Show getShow() { return show; }
    public List<ShowSeat> getBookedSeats() { return bookedSeats; }
    public double getTotalAmount() { return totalAmount; }
    public BookingStatus getBookingStatus() { return bookingStatus; }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}