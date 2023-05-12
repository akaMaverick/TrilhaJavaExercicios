import java.util.ArrayList;
import java.util.List;

public class MovieRepository {

    private List<Movie> movieList = new ArrayList<>();

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void addMovie(Movie movie) {
        movieList.add(movie);
    }

    public void removeMovie(Movie movie) {
        movieList.removeIf(item -> item.getTitle().equalsIgnoreCase(movie.getTitle()));
    }

    public List<Movie> searchMovies(MovieFilter movieFilter) {
        List<Movie> resultMovies = new ArrayList<>();
        for(Movie movie: movieList) {
            if(movieFilter.filter(movie)) {
                resultMovies.add(movie);
            }
        }
        return resultMovies;
    }

    public List<Movie> searchOneMovie(Movie movieSearch) {
        List<Movie> resultMovie = new ArrayList<>();
        for(Movie movie: movieList) {
            if(movie.getTitle().equalsIgnoreCase(movieSearch.getTitle())) {
                resultMovie.add(movie);
            }
        }
        return resultMovie;
    }
}
