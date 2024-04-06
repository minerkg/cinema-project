package ro.ubb.cinema.ui;

import ro.ubb.cinema.domain.ClientCard;
import ro.ubb.cinema.domain.Movie;
import ro.ubb.cinema.domain.Reservation;
import ro.ubb.cinema.service.MovieService;

import java.util.Scanner;

public class AppConsole {
    private Scanner scanner = new Scanner(System.in);
    private MovieService movieService;

    public AppConsole(MovieService movieService) {
        this.movieService = movieService;
    }

    private static void printChar(char c, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(c);
        }
        System.out.println();
    }

    private Movie getMovieDetails() {
        System.out.print("Enter Movie ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Title: ");
        String title = scanner.next();
        System.out.print("Enter Year: ");
        int year = scanner.nextInt();
        System.out.print("Enter Ticket Price: ");
        String ticketPrice = scanner.next();
        System.out.print("Is it currently in cinema? (true/false): ");
        boolean inCinema = scanner.nextBoolean();

        return new Movie(id, title, year, ticketPrice, inCinema);
    }

    public Movie getUpdatedMovieDetails(int id) {
        System.out.println("Enter new values for the movie (press enter to keep existing values): ");
        Movie currentMovie = movieService.getById(id);
        scanner.nextLine();

        System.out.print("Title: " + currentMovie.getTitle() + " or: ");
        String titleInput = scanner.nextLine();
        String title = !titleInput.isEmpty() ? titleInput : currentMovie.getTitle();

        System.out.print("Year: " + currentMovie.getYear() + " or: ");
        String yearInput = scanner.nextLine();
        int year = !yearInput.isEmpty() ? Integer.parseInt(yearInput) : currentMovie.getYear();

        System.out.print("Ticket Price: " + currentMovie.getTicketPrice() + " or: ");
        String ticketPriceInput = scanner.nextLine();
        String ticketPrice = !ticketPriceInput.isEmpty() ? ticketPriceInput : currentMovie.getTicketPrice();

        System.out.print("Is it currently in cinema? (" + currentMovie.isInCinema() + ") or: ");
        String inCinemaInput = scanner.nextLine();
        boolean inCinema = !inCinemaInput.isEmpty() ? Boolean.parseBoolean(inCinemaInput) : currentMovie.isInCinema();

        return new Movie(currentMovie.getId(), title, year, ticketPrice, inCinema);
    }


    private void showCinemaDetails() {
        printChar('-', 80);
        System.out.println("Movies are: ");
        for (Movie movie : movieService.getAll()) {
            System.out.println(movie);
        }
//        printChar('-', 100);
        System.out.println("Client Cards are: ");
//        for (ClientCard clientCard : clientCard.getAll()) {
//            System.out.println(clientCard);
//        }
//        printChar('-', 100);
        System.out.println("Reservations are: ");
//        for (Reservation reservation : reservationService.getAll()) {
//            System.out.println(reservation);
//        }
        printChar('-', 80);

    }

    private void displayMenu() {
        printChar('-', 50);
        System.out.println("Welcome to the Cinema Management System!");
        System.out.println("0. Exit");
        System.out.println("1. Add Movie");
        System.out.println("2. Show Movies");
        System.out.println("3. Update Movie");
        System.out.println("4. Delete Movie");
        System.out.println("5. Add Client Card");
        System.out.println("6. Show Client Cards");
        System.out.println("7. Update Client Card");
        System.out.println("8. Delete Client Card");
        System.out.println("9. Add Reservation");
        System.out.println("10. Show Reservations");
        System.out.println("11. Update Reservation");
        System.out.println("12. Delete Reservation");
        System.out.println("13. Show Cinema Details");
        System.out.print("Enter your choice: ");
    }

    public void runConsole() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            try {
                switch (choice) {
                    case 1:
                        // Add Movie
                        movieService.add(getMovieDetails());
                        break;
                    case 2:
                        System.out.println("Movies are: ");
                        for (Movie movie : movieService.getAll()) {
                            System.out.println(movie);
                        }
                        break;
                    case 3:
                        System.out.println("Enter Movie ID: ");
                        movieService.update(getUpdatedMovieDetails(scanner.nextInt()));
                        break;
                    case 4:
                        System.out.println("Enter Movie ID: ");
                        movieService.deleteById(scanner.nextInt());
                        break;
                    case 5:
                        // Add Client Card
                        break;
                    case 9:
                        // Add Reservation
                        break;
                    case 13:
                        showCinemaDetails();
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (RuntimeException re) {
                System.out.println("Error: " + re.getMessage());
            }
        }
    }
}
