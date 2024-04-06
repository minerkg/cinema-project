package ro.ubb.cinema.service;

import ro.ubb.cinema.domain.Movie;
import ro.ubb.cinema.repository.CinemaRepository;

import java.util.List;

public class MovieService {
    private CinemaRepository<Movie> cinemaRepository;

    public MovieService(CinemaRepository<Movie> cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    public List<Movie> getAllMovies() {
        return cinemaRepository.findAll();
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
