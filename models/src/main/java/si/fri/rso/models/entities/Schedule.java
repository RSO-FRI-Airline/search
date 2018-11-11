package si.fri.rso.models.entities;


import javax.persistence.*;
import java.sql.Time;

@Entity
public class Schedule extends BaseEntity {

    private String origin;

    private String destination;

    private int day_of_week;

    private Time start_time;

    private Time end_time;

    @ManyToOne
    private Airplane plane;
}
