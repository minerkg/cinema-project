package ro.ubb.cinema.domain;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientCardValidator {
    private static final Pattern CNP_PATTERN = Pattern.compile("\\d{13}");

    public static void validate(ClientCard clientCard) {
        if (clientCard == null) {
            throw new RuntimeException("Card client object is null.");
        }

        if (clientCard.getLastName() == null || clientCard.getLastName().isEmpty()) {
            throw new RuntimeException("Last name cannot be empty.");
        }

        if (clientCard.getFirstName() == null || clientCard.getFirstName().isEmpty()) {
            throw new RuntimeException("First name cannot be empty.");
        }

        if (!validateCNP(clientCard.getCnp())) {
            throw new RuntimeException("Invalid CNP format or CNP already exists.");
        }

        LocalDate currentDate = LocalDate.now();
        if (clientCard.getBirthDate().isAfter(currentDate)) {
            throw new RuntimeException("Birth date cannot be in the future.");
        }
    }

    private static boolean validateCNP(String cnp) {
        Matcher matcher = CNP_PATTERN.matcher(cnp);
        return matcher.matches();
    }
}
