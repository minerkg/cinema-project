package ro.ubb.cinema.domain;

import java.time.LocalDateTime;

public class Reservation extends BaseEntity {
    private int filmId;
    private int clientCardId;
    private LocalDateTime dayAndTime;

    public Reservation(int id, int filmId, int clientCardId, LocalDateTime dayAndTime) {
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

    public LocalDateTime getDayAndTime() {
        return dayAndTime;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public void setClientCardId(int clientCardId) {
        this.clientCardId = clientCardId;
    }

    public void setDayAndTime(LocalDateTime dayAndTime) {
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
