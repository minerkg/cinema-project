package ro.ubb.cinema.repository;

import ro.ubb.cinema.domain.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieRepositoryImpl implements MovieRepository {
    private List<Movie> movieList;

    public MovieRepositoryImpl() {
        movieList = new ArrayList<>();
    }

    @Override
    public List<Movie> findAll() {
        return movieList;
    }

    @Override
    public void save(Movie movie) {
        // TODO: implement save movie
    }

    @Override
    public void update(Movie movie) {
        // TODO: implement update
    }


    public Movie findById(int id) {
        // TODO: implement findById
        return null;
    }

    @Override
    public void deleteById(int id) {
        // TODO: implement deleteById
    }
}
