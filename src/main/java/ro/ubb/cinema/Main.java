package ro.ubb.cinema;

import ro.ubb.cinema.domain.ClientCard;
import ro.ubb.cinema.domain.Movie;
import ro.ubb.cinema.domain.Reservation;
import ro.ubb.cinema.repository.CinemaRepository;
import ro.ubb.cinema.repository.CinemaRepositoryImpl;
import ro.ubb.cinema.service.ClientCardService;
import ro.ubb.cinema.service.MovieService;
import ro.ubb.cinema.service.ReservationService;
import ro.ubb.cinema.ui.AppConsole;



public class Main {

    public static void main(String[] args) {
        CinemaRepository<Movie> movieRepository = new CinemaRepositoryImpl<Movie>();
        CinemaRepository<ClientCard> clientCardRepository = new CinemaRepositoryImpl<ClientCard>();
        CinemaRepository<Reservation> reservationRepository = new CinemaRepositoryImpl<Reservation>();
        MovieService movieService = new MovieService(movieRepository);
        ClientCardService clientCardService = new ClientCardService(clientCardRepository);
        ReservationService reservationService = new ReservationService(reservationRepository);

        AppConsole appConsole = new AppConsole(movieService, clientCardService, reservationService);

        appConsole.runConsole();
    }
}