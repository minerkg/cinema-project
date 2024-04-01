package ro.ubb.cinema;

import ro.ubb.cinema.repository.MovieRepository;
import ro.ubb.cinema.repository.MovieRepositoryImpl;
import ro.ubb.cinema.service.MovieService;
import ro.ubb.cinema.ui.AppConsole;

public class Main {

    public static void main(String[] args) {
        MovieRepository movieRepository = new MovieRepositoryImpl();
        MovieService movieService = new MovieService(movieRepository);

        AppConsole appConsole = new AppConsole(movieService);

        appConsole.runConsole();
    }
}