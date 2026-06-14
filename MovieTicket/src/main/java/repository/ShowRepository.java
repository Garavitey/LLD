package repository;

import Models.Show;
import java.util.Optional;
import java.util.List;

public interface ShowRepository {
    Show save(Show show);
    Optional<Show> findById(String showId);
    List<Show> findAll();
}