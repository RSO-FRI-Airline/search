package si.fri.rso.models.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Timestamp departure;

    private int free_seats;

    @ManyToOne
    private Schedule schedule_id;
}
