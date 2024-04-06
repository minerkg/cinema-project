package ro.ubb.cinema;

import ro.ubb.cinema.domain.Movie;
import ro.ubb.cinema.repository.CinemaRepository;
import ro.ubb.cinema.repository.CinemaRepositoryImpl;
import ro.ubb.cinema.service.MovieService;
import ro.ubb.cinema.ui.AppConsole;

public class Main {

    public static void main(String[] args) {
        CinemaRepository<Movie> movieRepository = new CinemaRepositoryImpl<Movie>();
        MovieService movieService = new MovieService(movieRepository);

        //Add Test Movies
        movieService.add(new Movie(1, "Inception", 2010, "$10", true));
        movieService.add(new Movie(2, "The Dark Knight", 2008, "$12", false));
        movieService.add(new Movie(3, "Interstellar", 2014, "$11", true));

        AppConsole appConsole = new AppConsole(movieService);

        appConsole.runConsole();
    }
}