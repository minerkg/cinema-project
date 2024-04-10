package ro.ubb.cinema.service;

import ro.ubb.cinema.domain.Reservation;
import ro.ubb.cinema.domain.ReservationValidator;
import ro.ubb.cinema.repository.CinemaRepository;

import java.util.List;

public class ReservationService {
    private CinemaRepository<Reservation> reservationRepository;

    public ReservationService(CinemaRepository<Reservation> reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void add(Reservation reservation) {
        ReservationValidator.validate(reservation);
        reservationRepository.save(reservation);
    }

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    public Reservation getById(int id) {
        return reservationRepository.findById(id);
    }

    public void update(Reservation newReservation) {
        ReservationValidator.validate(newReservation);
        reservationRepository.update(newReservation);
    }

    public void deleteById(int id) {
        reservationRepository.deleteById(id);
    }
}

