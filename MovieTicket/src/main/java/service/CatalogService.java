package service;

import Models.City;
import Models.Movie;
import Models.Show;
import Models.ShowSeat;
import repository.CityRepository;
import repository.ShowRepository;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CatalogService {
    private final CityRepository cityRepository;
    private final ShowRepository showRepository;

    public CatalogService(CityRepository cityRepository, ShowRepository showRepository) {
        this.cityRepository = cityRepository;
        this.showRepository = showRepository;
    }

    // 1. Get all unique movies playing in a specific city
    public List<Movie> getMoviesByCity(String cityId) {
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new RuntimeException("City not found!"));

        List<Movie> uniqueMovies = new ArrayList<>();

        // We look at all shows running in this city's theatres
        for (Show show : showRepository.findAll()) {
            // Check if the theatre showing this movie belongs to our target city
            boolean belongsToCity = city.getTheatres().stream()
                    .anyMatch(t -> t.getScreens().stream()
                            .anyMatch(s -> s.getScreenId().equals(show.getScreen().getScreenId())));

            if (belongsToCity && !uniqueMovies.contains(show.getMovie())) {
                uniqueMovies.add(show.getMovie());
            }
        }
        return uniqueMovies;
    }

    // 2. Get all shows for a specific movie in a city
    public List<Show> getShowsForMovie(String cityId, String movieId) {
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new RuntimeException("City not found!"));

        return showRepository.findAll().stream()
                .filter(show -> show.getMovie().getMovieId().equals(movieId))
                .filter(show -> city.getTheatres().stream()
                        .anyMatch(t -> t.getScreens().stream()
                                .anyMatch(s -> s.getScreenId().equals(show.getScreen().getScreenId()))))
                .collect(Collectors.toList());
    }

    // 3. Look up the seat layout map for a single showtime slice
    public List<ShowSeat> getSeatMapForShow(String showId) {
        Show show = showRepository.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show time not found!"));

        return show.getShowSeats(); // Returns the direct, real-time inventory map
    }
}