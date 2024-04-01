package ro.ubb.cinema.ui;

import ro.ubb.cinema.domain.Movie;
import ro.ubb.cinema.service.MovieService;

import java.util.List;

public class AppConsole {
    private MovieService movieService;

    public AppConsole(MovieService movieService) {
        this.movieService=movieService;
    }

    public void runConsole() {
        printAllMovies();
    }

    private void printAllMovies() {
        List<Movie> movieList = movieService.getAllMovies();
        System.out.println(movieList);
    }

    private void addMovie() {
        // TODO: implement add movie
    }

    private void updateMovie() {
        // TODO: implement update movie
    }

    private void deleteMovie() {
        // TODO: implement delete movie
    }
}
