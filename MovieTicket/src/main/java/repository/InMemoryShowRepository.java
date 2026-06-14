package repository;

import Models.Show;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

public class InMemoryShowRepository implements ShowRepository {
    private final Map<String, Show> database = new HashMap<>();

    @Override
    public Show save(Show show) {
        database.put(show.getShowId(), show);
        return show;
    }

    @Override
    public Optional<Show> findById(String showId) {
        return Optional.ofNullable(database.get(showId));
    }

    @Override
    public List<Show> findAll() {
        return new ArrayList<>(database.values());
    }
}