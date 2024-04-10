package ro.ubb.cinema.domain;

public class ReservationValidator {
    public static void validate(Reservation reservation) {
        if (reservation == null) {
            throw new RuntimeException("Reservation object is null.");
        }

        if (reservation.getFilmId() <= 0) {
            throw new RuntimeException("Invalid movie ID.");
        }

        if (reservation.getClientCardId() <= 0) {
            throw new RuntimeException("Invalid Client Card ID.");
        }

        if (reservation.getDayAndTime() == null) {
            throw new RuntimeException("Reservation date and time cannot be null.");
        }
    }
}
