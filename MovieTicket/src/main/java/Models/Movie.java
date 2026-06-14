package Models;

public class Movie {
    private final String movieId;
    private final String title;
    private final int durationInMinutes;

    public Movie(String movieId, String title, int durationInMinutes) {
        this.movieId = movieId;
        this.title = title;
        this.durationInMinutes = durationInMinutes;
    }

    public String getMovieId() { return movieId; }
    public String getTitle() { return title; }
    public int getDurationInMinutes() { return durationInMinutes; }
}