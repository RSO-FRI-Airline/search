package si.fri.rso.models.entities;


import javax.persistence.*;
import java.sql.Time;

@Entity(name = "schedule")
@NamedQueries(value =
        {
                @NamedQuery(name = "Schedule.getAll", query = "SELECT s FROM schedule as s")
        })
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String origin;

    private String destination;

    private int day_of_week;

    private Time start_time;

    private Time end_time;

    @ManyToOne
    private Plane plane;
}
