package ro.ubb.cinema.ui;

import ro.ubb.cinema.domain.ClientCard;
import ro.ubb.cinema.domain.Movie;
import ro.ubb.cinema.domain.Reservation;
import ro.ubb.cinema.service.ClientCardService;
import ro.ubb.cinema.service.MovieService;
import ro.ubb.cinema.service.ReservationService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class AppConsole {
    private Scanner scanner = new Scanner(System.in);
    private MovieService movieService;
    private ClientCardService clientCardService;
    private ReservationService reservationService;

    public AppConsole(MovieService movieService, ClientCardService clientCardService, ReservationService reservationService) {
        this.movieService = movieService;
        this.clientCardService = clientCardService;
        this.reservationService = reservationService;
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

    public ClientCard getCardDetails() {
        System.out.println("Enter Card ID: ");
        int id = scanner.nextInt();
        System.out.println("Enter First Name: ");
        String firstName = scanner.next();
        System.out.println("Enter Last Name: ");
        String lastName = scanner.next();
        System.out.println("Enter CNP: ");
        int cnp = scanner.nextInt();
        System.out.println("Enter Birth Date (yyyy-MM-dd): ");
        LocalDate birthDate = LocalDate.parse(scanner.next());
        System.out.println("Enter Registering Date (yyyy-MM-dd): ");
        LocalDate registeringDate = LocalDate.parse(scanner.next());
        System.out.println("Enter Loyalty Points: ");
        int loyaltyPoints = scanner.nextInt();

        return new ClientCard(id, firstName, lastName, cnp, birthDate, registeringDate, loyaltyPoints);
    }

    public ClientCard getUpdatedCardDetails(int id) {
        System.out.println("Enter new values for the card (press enter to keep existing values): ");
        ClientCard currentCard = clientCardService.getById(id);

        scanner.nextLine();

        System.out.println("First Name: " + currentCard.getFirstName() + " or: ");
        String firstNameInput = scanner.nextLine();
        String firstName = !firstNameInput.isEmpty() ? firstNameInput : currentCard.getFirstName();

        System.out.println("Last Name: " + currentCard.getLastName() + " or: ");
        String lastNameInput = scanner.nextLine();
        String lastName = !lastNameInput.isEmpty() ? lastNameInput : currentCard.getLastName();

        System.out.println("CNP: " + currentCard.getCnp() + " or: ");
        String cnpInput = scanner.nextLine();
        int cnp = !cnpInput.isEmpty() ? Integer.parseInt(cnpInput) : currentCard.getCnp();

        System.out.println("Birth Date (yyyy-MM-dd): " + currentCard.getBirthDate() + " or: ");
        String birthDateInput = scanner.nextLine();
        LocalDate birthDate = !birthDateInput.isEmpty() ? LocalDate.parse(birthDateInput) : currentCard.getBirthDate();

        System.out.println("Registering Date (yyyy-MM-dd): " + currentCard.getRegisteringDate() + " or: ");
        String registeringDateInput = scanner.nextLine();
        LocalDate registeringDate = !registeringDateInput.isEmpty() ? LocalDate.parse(registeringDateInput) : currentCard.getRegisteringDate();

        System.out.println("Loyalty Points: " + currentCard.getLoyaltyPoints() + " or: ");
        String loyaltyPointsInput = scanner.nextLine();
        int loyaltyPoints = !loyaltyPointsInput.isEmpty() ? Integer.parseInt(loyaltyPointsInput) : currentCard.getLoyaltyPoints();

        return new ClientCard(currentCard.getId(), firstName, lastName, cnp, birthDate, registeringDate, loyaltyPoints);
    }

    public Reservation getReservationDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Reservation ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter Film ID: ");
        int filmId = scanner.nextInt();

        System.out.print("Enter Client Card ID: ");
        int clientCardId = scanner.nextInt();

        System.out.print("Enter Day and Time (yyyy-MM-dd-hh-mm-ss: ");
        LocalDateTime dayAndTime = LocalDateTime.parse(scanner.next());

        scanner.close();

        return new Reservation(id, filmId, clientCardId, dayAndTime);
    }

    public Reservation getUpdatedReservationDetails(int id) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter new values for the reservation (press enter to keep existing values): ");
        Reservation currentReservation = reservationService.getById(id);

        System.out.print("Film ID: " + currentReservation.getFilmId() + " or: ");
        int filmId = scanner.nextInt();

        System.out.print("Client Card ID: " + currentReservation.getClientCardId() + " or: ");
        int clientCardId = scanner.nextInt();

        System.out.print("Day and Time (yyyy-MM-dd-hh-mm-ss): " + currentReservation.getDayAndTime() + " or: ");
        LocalDateTime dayAndTime = LocalDateTime.parse(scanner.next());

        scanner.close();

        return new Reservation(currentReservation.getId(), filmId, clientCardId, dayAndTime);
    }

    private void showCinemaDetails() {
        printChar('-', 80);
        System.out.println("Movies are: ");
        for (Movie movie : movieService.getAll()) {
            System.out.println(movie);
        }
        printChar('-', 60);
        System.out.println("Client Cards are: ");
        for (ClientCard clientCard : clientCardService.getAll()) {
            System.out.println(clientCard);
        }
        printChar('-', 60);
        System.out.println("Reservations are: ");
        for (Reservation reservation : reservationService.getAll()) {
            System.out.println(reservation);
        }
        printChar('-', 80);

    }

    private void displayMenu() {
        printChar('-', 50);
        System.out.println("Welcome to the Cinema Management System!");
        System.out.println("0. Exit");
        System.out.println("1. Add Movie");
        System.out.println("2. Update Movie");
        System.out.println("3. Delete Movie");
        System.out.println("4. Add Client Card");
        System.out.println("5. Update Client Card");
        System.out.println("6. Delete Client Card");
        System.out.println("7. Add Reservation");
        System.out.println("8. Update Reservation");
        System.out.println("9. Delete Reservation");
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
                        movieService.add(getMovieDetails());
                        break;
                    case 2:
                        System.out.println("Enter Movie ID: ");
                        movieService.update(getUpdatedMovieDetails(scanner.nextInt()));
                        break;
                    case 3:
                        System.out.println("Enter Movie ID: ");
                        movieService.deleteById(scanner.nextInt());
                        break;
                    case 4:
                        clientCardService.add(getCardDetails());
                        break;
                    case 5:
                        System.out.println("Enter Client Card ID: ");
                        clientCardService.update(getUpdatedCardDetails(scanner.nextInt()));
                        break;
                    case 6:
                        System.out.println("Enter Client Card ID: ");
                        clientCardService.deleteById(scanner.nextInt());
                        break;
                    case 7:
                        reservationService.add(getReservationDetails());
                        break;
                    case 8:
                        System.out.println("Enter Reservation ID: ");
                        reservationService.update(getUpdatedReservationDetails(scanner.nextInt()));
                        break;
                    case 9:
                        System.out.println("Enter Reservation ID: ");
                        reservationService.deleteById(scanner.nextInt());
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
