package ro.ubb.cinema.domain;

import java.time.LocalDate;

public class Reservation extends BaseEntity {
    // TODO: Clientul acumulează pe card 10% (parte întreagă) din prețul filmului. Se tipărește numărul total de puncte de pe card. Rezervarea se poate face doar dacă filmul este încă în program.

    private int filmId;
    private int clientCardId; // poate fii null
    private LocalDate dayAndTime;

    public Reservation(int id, int filmId, int clientCardId, LocalDate dayAndTime) {
        super(id);
        this.filmId = filmId;
        this.clientCardId = clientCardId;
        this.dayAndTime = dayAndTime;
    }

    public int getFilmId() {
        return filmId;
    }

    public int getClientCardId() {
        return clientCardId;
    }

    public LocalDate getDayAndTime() {
        return dayAndTime;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public void setClientCardId(int clientCardId) {
        this.clientCardId = clientCardId;
    }

    public void setDayAndTime(LocalDate dayAndTime) {
        this.dayAndTime = dayAndTime;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "filmId=" + filmId +
                ", clientCardId=" + clientCardId +
                ", dayAndTime=" + dayAndTime +
                '}';
    }
}
