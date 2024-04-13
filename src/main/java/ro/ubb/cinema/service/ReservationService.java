package ro.ubb.cinema.service;

import ro.ubb.cinema.domain.Reservation;
import ro.ubb.cinema.domain.ReservationValidator;
import ro.ubb.cinema.repository.CinemaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public List<Reservation> deleteReservationBetweenDays(LocalDate startDate, LocalDate endDate) {
        List<Reservation> reservationsToDelete = reservationRepository.findAll().
                stream().
                filter(
                        reservation -> reservation.getDayAndTime().isAfter(startDate.atStartOfDay()) &&
                                reservation.getDayAndTime().isBefore(endDate.atTime(23, 59))
                ).
                toList();
        if (!reservationsToDelete.isEmpty()) {
            for (Reservation reservation: reservationsToDelete) {
                reservationRepository.deleteById(reservation.getId());
            }
            return reservationsToDelete;
        }
        return null;
    }
    public Map<Integer,Integer> bestMovies(){
        Map<Integer, Integer> nrReservation= new HashMap<>();
        for (Reservation reservation : getAll()){
            int filmId = reservation.getFilmId();
            nrReservation.put(filmId,nrReservation.getOrDefault(filmId, 0) +1);
        }
        return nrReservation;

    }
    public List<Reservation> getReservationListInterval(int startingTime, int endingTime) {
        return getAll().stream().filter(transaction -> transaction.getDayAndTime().getHour() >= startingTime &&
                transaction.getDayAndTime().getHour() <= endingTime).collect(Collectors.toList());
    }

}

