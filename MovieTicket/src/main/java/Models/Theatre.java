package Models;

import java.util.List;

public class Theatre {
    private final String theatreId;
    private final String name;
    private final List<Screen> screens;

    public Theatre(String theatreId, String name, List<Screen> screens) {
        this.theatreId = theatreId;
        this.name = name;
        this.screens = screens;
    }

    public String getTheatreId() { return theatreId; }
    public String getName() { return name; }
    public List<Screen> getScreens() { return screens; }
}