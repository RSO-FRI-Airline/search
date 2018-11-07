package si.fri.rso.models.entities;

import javax.persistence.*;


@Entity(name = "price")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private float price;

    @ManyToOne
    private Flight flight_id;

    @ManyToOne
    private Flight class_id;
}
