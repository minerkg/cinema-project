package ro.ubb.cinema.service;

import ro.ubb.cinema.domain.Movie;
import ro.ubb.cinema.repository.MovieRepository;
import ro.ubb.cinema.repository.MovieRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public void addMovie() {
        // TODO: implement movie
    }

    public void updateMovie() {
        // TODO: implement service update
    }

    public void findMovie() {
        // TODO: implement service find movie
    }

    public void deleteMovie() {
        // TODO: implement service delete movie
    }
}
