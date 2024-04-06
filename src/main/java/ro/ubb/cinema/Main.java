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

        AppConsole appConsole = new AppConsole(movieService);

        appConsole.runConsole();
    }
}