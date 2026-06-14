package repository;

import Models.City;
import Models.Show;

import java.util.List;
import java.util.Optional;

public interface CityRepository {
    City save(City city);
    Optional<City> findById(String CityId);
    List<City> findAll();
}
