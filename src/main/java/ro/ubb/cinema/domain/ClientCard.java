package ro.ubb.cinema.domain;

import java.time.LocalDate;

public class ClientCard extends BaseEntity {
    private String firstName;
    private String lastName;
    private int cnp;
    private LocalDate birthDate;
    private LocalDate registeringDate;
    private int loyaltyPoints;

    public ClientCard(int id, String firstName, String lastName, int cnp, LocalDate birthDate, LocalDate registeringDate, int loyaltyPoints) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnp = cnp;
        this.birthDate = birthDate;
        this.registeringDate = registeringDate;
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCnp() {
        return cnp;
    }

    public void setCnp(int cnp) {
        this.cnp = cnp;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getRegisteringDate() {
        return registeringDate;
    }

    public void setRegisteringDate(LocalDate registeringDate) {
        this.registeringDate = registeringDate;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    @Override
    public String toString() {
        return "ClientCard{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cnp=" + cnp +
                ", birthDate=" + birthDate +
                ", registeringDate=" + registeringDate +
                ", loyaltyPoints=" + loyaltyPoints +
                '}';
    }
}
