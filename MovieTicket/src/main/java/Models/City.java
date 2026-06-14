package Models;

import java.util.List;

public class City {
    private final String cityId;
    private final String name;
    private final List<Theatre> theatres;

    public City(String cityId, String name, List<Theatre> theatres) {
        this.cityId = cityId;
        this.name = name;
        this.theatres = theatres;
    }

    public String getCityId() { return cityId; }
    public String getName() { return name; }
    public List<Theatre> getTheatres() { return theatres; }
}