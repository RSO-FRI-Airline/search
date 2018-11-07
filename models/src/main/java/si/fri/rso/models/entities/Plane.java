package si.fri.rso.models.entities;

import javax.persistence.*;

@Entity(name = "plane")
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private int number_of_seats;
}
