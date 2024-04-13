package ro.ubb.cinema.ui;

import ro.ubb.cinema.domain.ClientCard;
import ro.ubb.cinema.domain.Movie;
import ro.ubb.cinema.domain.Reservation;
import ro.ubb.cinema.service.ClientCardService;
import ro.ubb.cinema.service.MovieService;
import ro.ubb.cinema.service.ReservationService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
        double ticketPrice = scanner.nextDouble();
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
        double ticketPrice = !ticketPriceInput.isEmpty() ? Double.parseDouble(ticketPriceInput) : currentMovie.getTicketPrice();

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
        String cnp = scanner.next();
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
        String cnp = !cnpInput.isEmpty() ? cnpInput : currentCard.getCnp();

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



    public void addMockData() {
        movieService.add(new Movie(1, "Inception", 2010, 15, true));
        movieService.add(new Movie(2, "The Dark Knight", 2008, 20, false));
        movieService.add(new Movie(3, "Interstellar", 2014, 12, true));

        // Add Test Client Cards
        clientCardService.add(new ClientCard(1, "John", "Doe", "1234567890123", LocalDate.of(1990, 5, 15), LocalDate.now(), 1));
        clientCardService.add(new ClientCard(2, "Jane", "Smith", "1234567890234", LocalDate.of(1985, 10, 25), LocalDate.now(), 0));
        clientCardService.add(new ClientCard(3, "Alice", "Johnson", "1234567890345", LocalDate.of(1978, 3, 8), LocalDate.now(), 1));
        clientCardService.add(new ClientCard(4, "Balazs", "Doe", "1234567890345", LocalDate.of(1978, 3, 8), LocalDate.now(), 1));

        // Add Test Reservations
        reservationService.add(new Reservation(1, 1, 1, LocalDateTime.of(2024, 4, 10, 12, 30, 45)));
        reservationService.add(new Reservation(2, 2, 4, LocalDateTime.of(2024, 4, 11, 11, 55, 33)));
        reservationService.add(new Reservation(3, 3, 3, LocalDateTime.of(2024, 4, 12, 20, 45, 3)));
        reservationService.add(new Reservation(4, 1, 2, LocalDateTime.of(2024, 4, 12, 20, 45, 3)));
        reservationService.add(new Reservation(5, 3, 3, LocalDateTime.of(2024, 4, 12, 20, 45, 3)));
        reservationService.add(new Reservation(6, 3, 4, LocalDateTime.of(2024, 4, 11, 11, 55, 33)));

    }
    private void displayMenu() {
        printChar('-', 50);
        String mainMenu = """
                1. Crud menu
                2. Add mock data
                3. Get reservation between date-time
                4. Top Films by reservation
                5. Add bonus points for birthday
                6. Search for a movie by name
                7. Search for a client by name
                8. Show all reservations, movies, client cards
                9. Show all client cards ordered by points (descending)
                10. Delete all reservations between two dates
                """;
        System.out.println(mainMenu);

        System.out.print("Enter your choice: ");
    }


    public void runConsole() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    crudMenu();
                    break;
                case 2:
                    addMockData();
                    break;
                case 3:
                    getReservationBetweenTime();
                    break;
                case 4:
                    getBestMovieByReservation();
                    break;
                case 5:
                    addBonusForBirthday();
                    break;
                case 6:
                    System.out.println("Enter movie name: ");
                    System.out.println(movieService.searchMovies(scanner.next()));
                    break;
                case 7:
                    System.out.println("Enter client name: ");
                        System.out.println(clientCardService.searchClients(scanner.next()));;
                        break;
                case 8:
                    showCinemaDetails();
                        break;
                case 9:
                    //show client cards orderd by point
                        System.out.println(clientCardService.getClientCardsByPoints());
                        break;
                case 10:
                    //delete all reservations between two dates
                        System.out.println("Please enter the start date for reservation deletion: ");
                        LocalDate start = LocalDate.parse(scanner.next());
                        System.out.println("Please enter the end date for reservation deletion: ");
                        LocalDate end = LocalDate.parse(scanner.next());
                        System.out.println("You deleted the following reservation(s): ");
                        System.out.println(reservationService.deleteReservationBetweenDays(start, end));;
                        break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private void displayCrudMenu() {
        printChar('-', 50);
        System.out.println("Welcome to the Cinema Management System!");
        System.out.println("0. Back To Main Menu");
        System.out.println("1. Add Movie");
        System.out.println("2. Update Movie");
        System.out.println("3. Delete Movie");
        System.out.println("4. Add Client Card");
        System.out.println("5. Update Client Card");
        System.out.println("6. Delete Client Card");
        System.out.println("7. Add Reservation");
        System.out.println("8. Update Reservation");
        System.out.println("9. Delete Reservation");
        System.out.println("10. Search Movies");
        System.out.println("11. Search Clients");
        System.out.println("13. Show Cinema Details");
        System.out.print("Enter your choice: ");
    }

    private void crudMenu() {
        try {
            displayCrudMenu();
            int choice = scanner.nextInt();
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
                case 10:
                    System.out.println("Enter movie name: ");
                    movieService.searchMovies(scanner.next());
                    break;
                case 11:
                    System.out.println("Enter client name: ");
                    clientCardService.searchClients(scanner.next());
                    break;
                case 13:
                    showCinemaDetails();
                    break;
                case 0:
                    System.out.println("Back to main meniu...");
                    runConsole();
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (
                RuntimeException re) {
            System.out.println("Error: " + re.getMessage());
        }
    }

    public void addBonusForBirthday() {
        System.out.println("Enter how much bonus point want to add those cards: ");
        int points = scanner.nextInt();
        System.out.println("Introduce starting date (YYYY-MM-dd)");
        String startDate = scanner.next();
        System.out.println("Introduce ending date (YYYY-MM-dd)");
        String endDate = scanner.next();
        LocalDate startDateFormated = LocalDate.parse(startDate);
        LocalDate endDateFormated = LocalDate.parse(endDate);
        clientCardService.addBonusToClients(startDateFormated, endDateFormated, points);
    }
    private void getBestMovieByReservation() {
        Map<Integer,Integer> myMap = reservationService.bestMovies();

        List<Integer> filmId = myMap.keySet().stream().toList();

        List<Map.Entry<Integer,Integer>> listacuEntry = new ArrayList<>(myMap.entrySet());
        Collections.sort(listacuEntry, (a, b) -> b.getValue().compareTo(a.getValue()));

        for (Integer filmIds : filmId){
            System.out.println("Filmul cu ID:" + filmIds + "with name: " + movieService.getById(filmIds).getTitle() + "Nr rezervatiion: " + myMap.get(filmIds));
        }
        for (Map.Entry<Integer,Integer> entry : listacuEntry){
            int entryFilmId= entry.getKey();
            int nrReservation = entry.getValue();
            System.out.println("Filmul cu ID:" + entryFilmId + "with name: " + movieService.getById(entryFilmId).getTitle() + "Nr rezervatiion: " + nrReservation);
        }

    }
    public void getReservationBetweenTime(){
        String dateTimePattern = "YYYY-MM-DD HH";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateTimePattern).withLocale(Locale.ROOT);
        System.out.println("Type starting date and time in format: YYYY-MM-DD HH");
        int userInputStartHour = scanner.nextInt();
        System.out.println("Type ending date and time in format: YYYY-MM-DD HH");
        int userInputEndHour = scanner.nextInt();

        reservationService.getReservationListInterval(userInputStartHour,userInputEndHour).forEach(System.out::println);
    }
}
