package ro.ubb.cinema.domain;

public class Movie extends BaseEntity {
    private String title;
    private int year;
    private double ticketPrice;
    private boolean inCinema;

    public Movie(int id, String title, int year, double ticketPrice, boolean inCinema) {
        super(id);
        this.title = title;
        this.year = year;
        this.ticketPrice = ticketPrice;
        this.inCinema = inCinema;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public boolean isInCinema() {
        return inCinema;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void setInCinema(boolean inCinema) {
        this.inCinema = inCinema;
    }

    @Override
    public String toString() {
        return "Movie { " + "id: " + getId() +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", ticketPrice='" + ticketPrice + '\'' +
                ", inCinema=" + inCinema +
                '}';
    }
}
