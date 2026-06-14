package repository;

import Models.City;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ArrayList;

public class InMemoryCityRepository implements CityRepository {

    private final Map<String, City> database = new HashMap<>();

    @Override
    public City save(City city) {
        database.put(city.getCityId(), city);
        return city;
    }

    @Override
    public Optional<City> findById(String cityId) {
        return Optional.ofNullable(database.get(cityId));
    }

    @Override
    public List<City> findAll() {
        return new ArrayList<>(database.values());
    }
}