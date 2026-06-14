package Models;

import java.util.List;

public class Screen {
    private final String screenId;
    private final String name; // e.g., "Audi 1 - IMAX"
    private final List<PhysicalSeat> physicalSeats; // The static physical template

    public Screen(String screenId, String name, List<PhysicalSeat> physicalSeats) {
        this.screenId = screenId;
        this.name = name;
        this.physicalSeats = physicalSeats;
    }

    public String getScreenId() { return screenId; }
    public String getName() { return name; }
    public List<PhysicalSeat> getPhysicalSeats() { return physicalSeats; }
}