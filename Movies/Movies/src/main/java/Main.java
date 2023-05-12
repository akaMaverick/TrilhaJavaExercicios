import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
    private static final Logger logger = LogManager.getLogger("Main");
    public static void main(String[] args) {
        boolean verdadeiro = true;
        String title;
        int year;
        String genre;
        String director;
        int numberToSwitch = 0;

        MovieRecommendationService movieRecommendationService = new MovieRecommendationService();
        MovieRepository movieRepository = new MovieRepository();
        Movie movie1 = new Movie("Chefão", 1972, Genre.DRAMA, "Francis Ford Coppola", 7.0);
        Movie movie2 = new Movie("Exo", 1973, Genre.HORROR, "William Friedkin", 5.5);
        Movie movie3 = new Movie("Ghost", 1990, Genre.ROMANCE, "Jerry Zucker", 6.6);
        Movie movie4 = new Movie("A Hora do Pesadelo", 1984, Genre.HORROR, "Wes Craven", 7.5);
        Movie movie5 = new Movie("O Labirinto do Fauno", 2006, Genre.HORROR, "Guillermo del Toro", 8.2);
        Movie movie6 = new Movie("Quanto Mais Idiota Melhor", 1994, Genre.COMEDY, "Peter Segal", 6.9);
        Movie movie7 = new Movie("Jogos Mortais", 2004, Genre.HORROR, "James Wan", 7.6);
        Movie movie8 = new Movie("Psicose", 1960, Genre.HORROR, "Alfred Hitchcock", 8.5);
        Movie movie9 = new Movie("Jurassic Park: O Parque dos Dinossauros", 1993, Genre.ACTION, "Steven Spielberg", 8.1);
        Movie movie10 = new Movie("Sociedade dos Poetas Mortos", 1989, Genre.DRAMA, "Peter Weir", 8.1);
        Movie movie11 = new Movie("O Predador", 1987, Genre.ACTION, "John McTiernan", 7.8);
        Movie movie12 = new Movie("E.T.: O Extraterrestre", 1982, Genre.DRAMA, "Steven Spielberg", 7.8);
        Movie movie13 = new Movie("Os Bons Companheiros", 1990, Genre.DRAMA, "Martin Scorsese", 8.7);

        movieRepository.addMovie(movie1);
        movieRepository.addMovie(movie2);
        movieRepository.addMovie(movie3);
        movieRepository.addMovie(movie4);
        movieRepository.addMovie(movie5);
        movieRepository.addMovie(movie6);
        movieRepository.addMovie(movie7);
        movieRepository.addMovie(movie8);
        movieRepository.addMovie(movie9);
        movieRepository.addMovie(movie10);
        movieRepository.addMovie(movie11);
        movieRepository.addMovie(movie12);
        movieRepository.addMovie(movie13);
        Scanner scanner = new Scanner(System.in);


        do {

            logger.info("Bem-vindo ao sistema de gerenciamento de filmes!");
            logger.info("Digite o que você gostaria de fazer: " +
                    "\n1-Adicionar filme\n2-Remover filme\n3-Pesquisar filme\n4-Classificar um filme" +
                    "\n5-Recomandação de Filmes\n6-Fechar sistema");
            numberToSwitch = scanner.nextInt();

            switch (numberToSwitch) {
                case 1:
                    logger.info("Digite o título do filme: ");
                    scanner.nextLine();
                    title = scanner.nextLine();
                    logger.info("Digite o ano do filme: ");
                    year = scanner.nextInt();
                    logger.info("Digite o gênero do filme: ");
                    genre = scanner.next().toUpperCase();
                    logger.info("Digite o diretor do filme: ");
                    scanner.nextLine();
                    director = scanner.nextLine();
                    Movie movie = new Movie(title, year, Genre.valueOf(genre), director);
                    movieRepository.addMovie(movie);
                    break;
                case 2:
                    scanner.nextLine();
                    logger.info("Digite o nome do título a ser removido: ");
                    String titleRemover = scanner.nextLine();
                    Movie movieRemover = new Movie(titleRemover);
                    movieRepository.removeMovie(movieRemover);
                    break;
                case 3:
                    scanner.nextLine();
                    logger.info("Digite o nome do filme a ser pesquisado: ");
                    String titleSearch = scanner.nextLine();
                    Movie movieSearch = new Movie(titleSearch);
                    logger.info(movieRepository.searchOneMovie(movieSearch));
                    break;
                case 4:
                    scanner.nextLine();
                    logger.info("Digite o nome do filme que você gostaria de dar nota: ");
                    String titleToAddRating = scanner.nextLine();
                    logger.info("Digite a nota que gostaria de atribuir: ");
                    double ratingToAdd = scanner.nextDouble();
                    Movie movieRating = new Movie();
                    Movie movieAddRating = new Movie(titleToAddRating, ratingToAdd);
                    movieRating.addRating(movieRepository, movieAddRating);
                    break;
                case 5:
                    scanner.nextLine();
                    logger.info("Digite qual tipo de gênero: ");
                    genre = scanner.nextLine();
                    movieRecommendationService.setUserPreferences(Genre.valueOf(genre));
                    logger.info("Digite a partir de que nota você gostaria de filmes recomendados para você: ");
                    double ratingThreshold = scanner.nextDouble();
                    movieRecommendationService.setRatingThreshold(ratingThreshold);
                    logger.info(movieRecommendationService.recommendMovies(movieRepository));

                    break;
                case 6:
                    verdadeiro = false;
                    break;
                default:
                    logger.info("ERRO!");
            }
        } while (verdadeiro);


        scanner.close();
    }
}

