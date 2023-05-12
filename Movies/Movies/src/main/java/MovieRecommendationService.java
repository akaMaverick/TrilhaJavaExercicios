import java.util.List;

public class MovieRecommendationService implements MovieFilter {

    private Genre userPreferences;
    private double ratingThreshold;

    public void setRatingThreshold(double ratingThreshold) {
        this.ratingThreshold = ratingThreshold;
    }

    public void setUserPreferences(Genre userPreferences) {
        this.userPreferences = userPreferences;
    }

    @Override
    public boolean filter(Movie movie) {
        return movie.getGenre() == userPreferences && movie.getRating() > ratingThreshold;
    }

    public List<Movie> recommendMovies(MovieRepository movieRepository) {
        return movieRepository.searchMovies(this);
    }
}