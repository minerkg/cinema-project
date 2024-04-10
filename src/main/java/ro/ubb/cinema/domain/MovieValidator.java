package ro.ubb.cinema.domain;

public class MovieValidator {
    public static void validate(Movie movie) {
        if (movie == null) {
            throw new RuntimeException("Film object is null.");
        }

        if (movie.getTitle() == null || movie.getTitle().isEmpty()) {
            throw new RuntimeException("Title cannot be empty.");
        }

        if (movie.getYear() <= 0) {
            throw new RuntimeException("Release year must be a positive value.");
        }

        if (movie.getTicketPrice() <= 0) {
            throw new RuntimeException("Ticket price must be a positive value.");
        }
    }
}
