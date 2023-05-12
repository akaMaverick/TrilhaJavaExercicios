public class Movie {

    private String title;
    private int year;
    private Genre genre;
    private String director;
    private double rating;

    public Movie() {
    }
    public Movie(String title, int year, Genre genre, String director, double rating) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.director = director;
        this.rating = rating;
    }

    public Movie(String title, int year, Genre genre, String director) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.director = director;
    }

    public Movie(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    public Movie(String title) {
        this.title = title;
    }

    public void addRating(MovieRepository movieRepository, Movie movie) {
        for(int i = 0; i < movieRepository.getMovieList().size(); i++) {
            if(movieRepository.getMovieList().get(i).getTitle().equalsIgnoreCase(movie.getTitle())) {
                movieRepository.getMovieList().get(i).setRating(movie.getRating());
            }

        }
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", genre=" + genre +
                ", director='" + director + '\'' +
                ", rating=" + rating +
                '}';
    }
}