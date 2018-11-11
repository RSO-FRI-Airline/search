package si.fri.rso.models.entities;

import javax.persistence.*;


@Entity
public class Price extends BaseEntity{

    private float price;

    @ManyToOne
    private Flight flight_id;

    @ManyToOne
    private Flight class_id;
}
