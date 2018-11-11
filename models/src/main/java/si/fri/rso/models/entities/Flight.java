package si.fri.rso.models.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Flight extends BaseEntity{

    private Timestamp departure;

    private int free_seats;

    @ManyToOne
    private Schedule schedule_id;

}
