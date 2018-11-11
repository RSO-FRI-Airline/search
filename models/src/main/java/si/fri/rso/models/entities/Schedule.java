package si.fri.rso.models.entities;


import javax.persistence.*;
import java.sql.Time;

@Entity
public class Schedule extends RegisterEntity {

    @ManyToOne
    private Airport origin;

    @ManyToOne
    private Airport destination;

    private int day_of_week;

    private Time start_time;

    private Time end_time;

    @ManyToOne
    private Airplane airplane;

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public int getDay_of_week() {
        return day_of_week;
    }

    public void setDay_of_week(int day_of_week) {
        this.day_of_week = day_of_week;
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public Time getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane plane) {
        this.airplane = plane;
    }
}
