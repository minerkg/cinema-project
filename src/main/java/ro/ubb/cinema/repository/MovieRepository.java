package ro.ubb.cinema.repository;

import ro.ubb.cinema.domain.Movie;

import java.util.List;

public interface MovieRepository {

    List<Movie> findAll();

    Movie findById(int id);

    void save(Movie movie);

    void update(Movie movie);

    void deleteById(int id);
}
