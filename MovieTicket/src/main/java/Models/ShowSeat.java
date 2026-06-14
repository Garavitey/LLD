package Models;

public class ShowSeat {
    private final String showSeatId; // unique composite key e.g. "SHOW123-A1"
    private final PhysicalSeat physicalSeat;
    private boolean isBooked;

    public ShowSeat(String showSeatId, PhysicalSeat physicalSeat) {
        this.showSeatId = showSeatId;
        this.physicalSeat = physicalSeat;
        this.isBooked = false; // Fresh seats are always open initially
    }

    public String getShowSeatId() { return showSeatId; }
    public PhysicalSeat getPhysicalSeat() { return physicalSeat; }
    public boolean isBooked() { return isBooked; }

    // Setter to toggle booking status
    public void setBooked(boolean booked) { this.isBooked = booked; }
}