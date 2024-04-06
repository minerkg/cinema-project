package ro.ubb.cinema.ui;

import ro.ubb.cinema.domain.Movie;
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
        return null;
    }

    private void showCinemaDetails() {
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
                        break;
                    case 5:
                        // Add Client Card
                        break;
                    case 9:
                        // Add Reservation
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (RuntimeException re) {
                System.out.println("Error: " + re.getMessage());
                System.out.println("Track Stace: " + re.getStackTrace());
            }
        }
    }
}
