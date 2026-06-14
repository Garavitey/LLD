package Models;

import enums.SeatType;

public class PhysicalSeat {
    private final String seatId; // e.g., "A1", "B5"
    private final SeatType seatType; // e.g., VIP, PREMIUM

    public PhysicalSeat(String seatId, SeatType seatType) {
        this.seatId = seatId;
        this.seatType = seatType;
    }

    public String getSeatId() { return seatId; }
    public SeatType getSeatType() { return seatType; }
}