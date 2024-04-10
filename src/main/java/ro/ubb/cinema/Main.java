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

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        CinemaRepository<Movie> movieRepository = new CinemaRepositoryImpl<Movie>();
        CinemaRepository<ClientCard> clientCardRepository = new CinemaRepositoryImpl<ClientCard>();
        CinemaRepository<Reservation> reservationRepository = new CinemaRepositoryImpl<Reservation>();
        MovieService movieService = new MovieService(movieRepository);
        ClientCardService clientCardService = new ClientCardService(clientCardRepository);
        ReservationService reservationService = new ReservationService(reservationRepository);

        //Add Test Movies
        movieService.add(new Movie(1, "Inception", 2010, "$10", true));
        movieService.add(new Movie(2, "The Dark Knight", 2008, "$12", false));
        movieService.add(new Movie(3, "Interstellar", 2014, "$11", true));

        // Add Test Client Cards
        clientCardService.add(new ClientCard(1, "John", "Doe", 123456789, LocalDate.of(1990, 5, 15), LocalDate.now(), 1));
        clientCardService.add(new ClientCard(2, "Jane", "Smith", 987654321, LocalDate.of(1985, 10, 25), LocalDate.now(), 0));
        clientCardService.add(new ClientCard(3, "Alice", "Johnson", 456789123, LocalDate.of(1978, 3, 8), LocalDate.now(), 1));

        // Add Test Reservations
        reservationService.add(new Reservation(1, 1, 1, LocalDateTime.of(2024, 4, 10,12,30,45)));
        reservationService.add(new Reservation(2, 2, 2, LocalDateTime.of(2024, 4, 11,11,55,33)));
        reservationService.add(new Reservation(3, 3, 3, LocalDateTime.of(2024, 4, 12,20,45, 3)));

        AppConsole appConsole = new AppConsole(movieService, clientCardService, reservationService);

        appConsole.runConsole();
    }
}