package Models;

import java.util.ArrayList;
import java.util.List;

public class Show {
    private final String showId;
    private final Movie movie;
    private final Screen screen;
    private final long startTime; // Epoch timestamp
    private final long endTime;   // Epoch timestamp
    private final List<ShowSeat> showSeats; // The active inventory structure

    public Show(String showId, Movie movie, Screen screen, long startTime, long endTime) {
        this.showId = showId;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.endTime = endTime;
        this.showSeats = new ArrayList<>();

        // AUTOMATIC INVENTORY INFUSION:
        // Convert static layout blueprints into dynamic tracking instances
        for (PhysicalSeat physicalSeat : screen.getPhysicalSeats()) {
            String generatedId = showId + "-" + physicalSeat.getSeatId();
            this.showSeats.add(new ShowSeat(generatedId, physicalSeat));
        }
    }

    public String getShowId() { return showId; }
    public Movie getMovie() { return movie; }
    public Screen getScreen() { return screen; }
    public long getStartTime() { return startTime; }
    public long getEndTime() { return endTime; }
    public List<ShowSeat> getShowSeats() { return showSeats; }
}